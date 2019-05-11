package com.benali.controllers;


import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benali.entitites.ContactForm;
import com.benali.entitites.MailDB;
import com.benali.entitites.Produit;
import com.benali.entitites.User;
import com.benali.metier.MailDBMetier;
import com.benali.metier.ProduitMetier;
import com.benali.metier.UserMetier;

@Controller
public class HomeController {
	@Autowired
	private UserMetier UM;
	@Autowired
	private ProduitMetier PM;
	@Autowired
	private MailDBMetier MDBM;

	@RequestMapping(path = "/home")
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/l/home")
	public String index2(User user) {
		// User user = UM.addUser(u);
		return "l/index";
	}

	@RequestMapping(path = "/inscription", method = RequestMethod.GET)
	public String inscription(Model model) {
		model.addAttribute("user", new User());
		return "inscription";
	}

	@RequestMapping(path = "/inscription", method = RequestMethod.POST)
	public String inscription(User user) {
		if (user != null) {
			if (UM.findUser(user.getPseudo()) == null) {
				UM.addUser(user);
				return "inscrit";
			}
		}
		return "index";
	}

	// @RequestMapping(path="/connexion", method=RequestMethod.GET)
	// public String connexion(){
	// return "connexion";
	// }
	@RequestMapping(path = "/about")
	public String about() {
		return "about";
	}

	@RequestMapping(path = "/rechercher")
	public String rechercher(Model model, String search) {
		List<User> users = UM.findByKW(search);
		List<Produit> produits = PM.findProduit(search);
		model.addAttribute("produits", produits);
		model.addAttribute("users", users);
		return "rechercher";
	}

	@RequestMapping(path = "/l/rechercher")
	public String recherche(Model model, String search) {
		List<User> users = UM.findByKW(search);
		List<Produit> produits = PM.findProduit(search);
		model.addAttribute("produits", produits);
		model.addAttribute("users", users);
		return "l/recherche";
	}

	@RequestMapping(path = "/fail")
	public String fail() {
		return "fail";
	}

	@RequestMapping(path = "/l/contact")
	public String contact(Model model) {
		model.addAttribute("cf", new ContactForm());
		return "/l/contact";
	}

	@RequestMapping(path = "/l/msgenvoye", method = RequestMethod.POST)
	public String contact(Model model, ContactForm cf) {
		String nomContact = cf.getNomContact();
		String emailContact  = cf.getEmailContact();
		String messageContact = cf.getMessageContact();
		sendmsg(nomContact, emailContact, messageContact);
		return "/l/envoye";
	}

	private void sendmsg(String nomContact, String emailContact, String message) {
		Long IDMDB = new Long(1);
		MailDB MDB = MDBM.findMailId(IDMDB);
		String mail = MDB.getAdresseMailDB();
		String psw = MDB.getPswMailDB();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								mail, psw);
					}
				});
		System.out.println(psw);
		Message msg = new MimeMessage(session);
		try{
		msg.setFrom(new InternetAddress(emailContact, false));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("benalimoe@gmail.com"));
		msg.setSubject("Test message from "+nomContact+" /phones contact");
		msg.setContent(nomContact+" : "+emailContact+"\n"+message, "text/html");
		msg.setSentDate(new Date());

		Transport.send(msg);
		}catch(MessagingException me){
			System.out.println(me);
		}
	}

}