package com.bocobi2.orientation.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bocobi2.orientation.model.Borough;
import com.bocobi2.orientation.model.Client;
import com.bocobi2.orientation.model.Concession;
import com.bocobi2.orientation.model.Country;
import com.bocobi2.orientation.model.Department;
import com.bocobi2.orientation.model.ErrorClass;
import com.bocobi2.orientation.model.Locality;
import com.bocobi2.orientation.model.NewsletterConcern;
import com.bocobi2.orientation.model.Region;
import com.bocobi2.orientation.model.SuccessClass;
import com.bocobi2.orientation.model.Town;
import com.bocobi2.orientation.repositories.AdministratorRepository;
import com.bocobi2.orientation.repositories.ArticleRepository;
import com.bocobi2.orientation.repositories.BookRepository;
import com.bocobi2.orientation.repositories.BoroughRepository;
import com.bocobi2.orientation.repositories.ClientRepository;
import com.bocobi2.orientation.repositories.ConcessionRepository;
import com.bocobi2.orientation.repositories.CountryRepository;
import com.bocobi2.orientation.repositories.DepartmentRepository;
import com.bocobi2.orientation.repositories.LocalityRepository;
import com.bocobi2.orientation.repositories.NewsletterConcernRepository;
import com.bocobi2.orientation.repositories.NewsletterRepository;
import com.bocobi2.orientation.repositories.RegionRepository;
import com.bocobi2.orientation.repositories.ScholarshipRepository;
import com.bocobi2.orientation.repositories.SchoolCalenderRepository;
import com.bocobi2.orientation.repositories.TownRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orientation/surfer")
public class SurferController {

	public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	AdministratorRepository administratorRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	SchoolCalenderRepository schoolCalenderRepository;

	@Autowired
	ScholarshipRepository scholarshipRepository;

	@Autowired
	NewsletterRepository newsletterRepository;

	@Autowired
	NewsletterConcernRepository newsletterConcernRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	RegionRepository regionRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	BoroughRepository boroughRepository;
	
	@Autowired
	TownRepository townRepository;
	
	@Autowired
	ConcessionRepository concessionRepository;
	
	@Autowired
	LocalityRepository localityRepository;
	
	/****
	 * registration client in the data base methode qui gere l'enregistrement
	 * d'un membre dans la bd
	 * 
	 */
	//@SuppressWarnings("unchecked")
	/*
	 * Version POST
	 */
	/*@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<?> registrationPost(HttpServletRequest request, UriComponentsBuilder ucBuilder) {

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		// properties.put("mail.smtp.host", "smtp-relay.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "false");
		properties.put("mail.smtp.connectiontimeout", "5000");
		properties.put("mail.smtp.timeout", "5000");
		properties.put("mail.smtp.writetimeout", "5000");
		Session session = Session.getInstance(properties, null);

		/*
		 * recuperation des donnees du formulaire
		 /
		String orientationName = request.getParameter("orientationName");
		String pseudonym = request.getParameter("pseudonym");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String gender = request.getParameter("gender");
		String emailAdress = request.getParameter("emailAdress");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");

		// File fileWay = new File(SAVE_DIR_PICTURE);
		// String nom = "picture" + pseudonym + ".png";
		// Part part = null;
		// if (!fileWay.exists())
		// fileWay.mkdir();

		System.out.println("-------------------------------");
		System.out.println(pseudonym);
		System.out.println("-------------------------------");
		System.out.println(emailAdress);
		System.out.println("-------------------------------");
		System.out.println(password);
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println(phoneNumber);
		System.out.println("-------------------------------");

		if (orientationName.equals("Amoureuse")) {

			String fatherName = request.getParameter("fatherName");
			String motherName = request.getParameter("motherName");
			String countryName = request.getParameter("countryName");
			String regionName = request.getParameter("regionName");
			String departmentName = request.getParameter("departmentName");
			String boroughName = request.getParameter("boroughName");
			String townName = request.getParameter("townName");
			String concessionName = request.getParameter("concessionName");

			
			Country countryDB = countryRepository.findByCountryName(countryName);
			Region regionDB = regionRepository.findByRegionName(regionName);
			Department departmentDB = departmentRepository.findByDepartmentName(departmentName);
			Borough boroughDB = boroughRepository.findByBoroughName(boroughName);
			// Town town = townRepository.findByTownName(townName);
			// Concession concession=
			// concessionRepository.findByConcessionName(concessionName);

			Town town = new Town();
			Concession concession = new Concession();

			try {
				town.setTownName(townName);
				town.setBorough(boroughDB);

				townRepository.save(town);

			} catch (Exception ex) {
				logger.error("Unable to create. A Town with name {} already exist", townName);
				return new ResponseEntity(
						new ErrorClass(
								"Unable to create A Town with name " + townName + " already exist"),
						HttpStatus.OK);
			}

			Town townDB = townRepository.findByTownName(townName);

			try {
				concession.setConcessionName(concessionName);
				concession.setTown(townDB);

				concessionRepository.save(concession);

			} catch (Exception ex) {
				logger.error("Unable to create. A Concession with name {} already exist", concessionName);
				return new ResponseEntity(new ErrorClass(
						"Unable to create. " + "A Concession with name " + "" + concessionName + " already exist"),
						HttpStatus.CONFLICT);
			}
			Concession concessionDB = concessionRepository.findByConcessionName(concessionName);

			String idLocality = countryName + regionName + departmentName + boroughName + townName + concessionName;

			Locality locality = new Locality();

			locality.setIdLocalite(idLocality);
			locality.setCountry(countryDB);
			locality.setRegion(regionDB);
			locality.setDepartment(departmentDB);
			locality.setBorough(boroughDB);
			locality.setTown(townDB);
			locality.setConcession(concessionDB);

			localityRepository.save(locality);

			Locality localityDB = localityRepository.findByIdLocalite(idLocality);

			String idLocalityDB = localityDB.getIdLocalite();

			ChooseMeeting chooseMeeting = new ChooseMeeting();
			MemberBuffer client = new MemberBuffer();
			DatingInformation datingInformation = new DatingInformation();

			TypeOfOrientation typeMeeting = typeMeetingRepository.findByMeetingName(orientationName);

			String idTypeOfOrientation = typeMeeting.getId();
			String idChoose = pseudonym + idTypeOfOrientation;

			try {
				// part = request.getPart("picture");
				// String fileName = SAVE_DIR_PICTURE + File.separator + nom;
				// part.write(SAVE_DIR_PICTURE + File.separator + nom);

				if (clientRepository.findByPseudonym(pseudonym) != null) {

					// ChooseMeeting chooseMeetingBd
					// =chooseMeetingRepository.findByIdChooseMeeting(idChoose);
					if (chooseMeetingRepository.findByIdChooseMeeting(idChoose) != null) {

						return new ResponseEntity(
								new ErrorClass("the email and pseudonym are already created in this type orientation"),
								HttpStatus.OK);
					} else {
						Member clientBD = clientRepository.findByPseudonym(pseudonym);
						chooseMeeting.setIdChooseMeeting(idChoose);
						chooseMeetingRepository.save(chooseMeeting);

						datingInformation.setFatherName(fatherName);
						datingInformation.setMotherName(motherName);

						client.setPseudonym(clientBD.getPseudonym());
						client.setGender(clientBD.getGender());
						client.setBirthDate(clientBD.getBirthDate());
						client.setEmailAdress(clientBD.getEmailAdress());
						client.setPhoneNumber(clientBD.getPhoneNumber());
						client.setPassword(clientBD.getPassword());
						// client.setPicture(fileName);
						client.setFriendlyDatingInformatio(clientBD.getFriendlyDatingInformatio());
						client.setAcademicDatingInformation(clientBD.getAcademicDatingInformation());
						client.setProfessionalMeetingInformation(clientBD.getProfessionalMeetingInformation());

						client.setDatingInformation(datingInformation);

						try {

							String idComeLocality = pseudonym + idLocality;

							if (comeLocalityRepository.exists(idComeLocality)) {

								return new ResponseEntity(new ErrorClass("this locality is already exist"),
										HttpStatus.OK);
							}
							// enregistrement dans la zone tampon

							String content1 = "Thanks to create your count in our website \n"
									+ " Now,lick on this link to activate E-mail adress: "
									+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
									+ client.getPseudonym() + "&orientationName=" + orientationName;
							String subject1 = "confirm your E-mail adress";
							// String form="saphirmfogo@gmail.com";V
							MimeMessage msg = new MimeMessage(session);
							/// msg.setFrom(new InternetAddress(form));
							msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
							msg.setSubject(subject1);
							msg.setText(content1);
							msg.setSentDate(new Date());

							Transport transport = session.getTransport("smtp");
							transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
							transport.sendMessage(msg, msg.getAllRecipients());
							transport.close();

							// clientBufferRepository.deleteAll();
							clientBufferRepository.save(client);

							ComeLocality comeLocality = new ComeLocality();

							comeLocality.setId(idComeLocality);

							comeLocalityRepository.save(comeLocality);

							return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());

							logger.error("Unable to create. A Member with name {} already exist",
									client.getPseudonym());
							return new ResponseEntity(new ErrorClass("the email is not validate"),
									HttpStatus.OK);

						}
					}
				} else {

					// ChooseMeeting chooseMeetingBd
					// =chooseMeetingRepository.findByIdChooseMeeting(idChoose);
					if (chooseMeetingRepository.findByIdChooseMeeting(idChoose) != null) {

						return new ResponseEntity(
								new ErrorClass("this pseudonym is already using, please choose an another own"),
								HttpStatus.OK);
					} else {
						// Member clientBD =
						// clientRepository.findByPseudonym(pseudonym);
						chooseMeeting.setIdChooseMeeting(idChoose);
						// chooseMeetingRepository.deleteAll();
						chooseMeetingRepository.save(chooseMeeting);

						datingInformation.setFatherName(fatherName);
						datingInformation.setMotherName(motherName);

						client.setPseudonym(pseudonym);
						client.setGender(gender);
						client.setBirthDate(birthDate);
						client.setEmailAdress(emailAdress);
						client.setPhoneNumber(phoneNumber);
						client.setPassword(password);
						// client.setPicture(fileName);
						client.setFriendlyDatingInformatio(null);
						client.setAcademicDatingInformation(null);
						client.setProfessionalMeetingInformation(null);

						client.setDatingInformation(datingInformation);

						try {
							String idComeLocality = pseudonym + idLocality;

							if (comeLocalityRepository.exists(idComeLocality)) {

								return new ResponseEntity(new ErrorClass("this locality is already exist"),
										HttpStatus.OK);
							}
							// enregistrement dans la zone tampon

							String content1 = "Thanks to create your count in our website \n"
									+ " Now,lick on this link to activate E-mail adress: "
									+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
									+ client.getPseudonym() + "&orientationName=" + orientationName;
							String subject1 = "confirm your E-mail adress";
							// String form="saphirmfogo@gmail.com";V
							MimeMessage msg = new MimeMessage(session);
							/// msg.setFrom(new InternetAddress(form));
							msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
							msg.setSubject(subject1);
							msg.setText(content1);
							msg.setSentDate(new Date());

							Transport transport = session.getTransport("smtp");
							transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
							transport.sendMessage(msg, msg.getAllRecipients());
							transport.close();

							// clientBufferRepository.deleteAll();
							clientBufferRepository.save(client);

							ComeLocality comeLocality = new ComeLocality();

							comeLocality.setId(idComeLocality);

							comeLocalityRepository.save(comeLocality);

							return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());

							logger.error("Unable to create. A Member with name {} already exist",
									client.getPseudonym());
							return new ResponseEntity(new ErrorClass("the email is not validate"),
									HttpStatus.OK);

						}
					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());

				logger.error("Unable to create. A Member with name {} already exist", client.getPseudonym());
				return new ResponseEntity(new ErrorClass("the email is not validate1"), HttpStatus.OK);

			}

		} else if (orientationName.equals("Professionnelle")) {

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String profession = request.getParameter("profession");
			String levelStudy = request.getParameter("levelStudy");

			ChooseMeeting chooseMeeting = new ChooseMeeting();
			MemberBuffer client = new MemberBuffer();
			ProfessionalMeetingInformation professionalMeeting = new ProfessionalMeetingInformation();

			TypeOfOrientation typeMeeting = typeMeetingRepository.findByMeetingName(orientationName);

			String idTypeOfOrientation = typeMeeting.getId();
			String idChoose = pseudonym + idTypeOfOrientation;

			try {
				// part = request.getPart("picture");
				// String fileName = SAVE_DIR_PICTURE + File.separator + nom;
				// part.write(SAVE_DIR_PICTURE + File.separator + nom);

				// Member clientBD =
				// clientRepository.findByPseudonym(pseudonym);

				if (clientRepository.findByPseudonym(pseudonym) != null) {

					ChooseMeeting chooseMeetingBd = chooseMeetingRepository.findByIdChooseMeeting(idChoose);
					if (chooseMeetingBd != null) {

						return new ResponseEntity(
								new ErrorClass("the email and pseudonym are already created in this type orientation"),
								HttpStatus.OK);
					} else {

						Member clientBD = clientRepository.findByPseudonym(pseudonym);
						chooseMeeting.setIdChooseMeeting(idChoose);
						chooseMeetingRepository.save(chooseMeeting);

						professionalMeeting.setFirstName(firstName);
						professionalMeeting.setLastName(lastName);
						professionalMeeting.setLevelStudy(levelStudy);
						professionalMeeting.setProfession(profession);

						client.setPseudonym(clientBD.getPseudonym());
						client.setGender(clientBD.getGender());
						client.setBirthDate(clientBD.getBirthDate());
						client.setEmailAdress(clientBD.getEmailAdress());
						client.setPhoneNumber(clientBD.getPhoneNumber());
						client.setPassword(clientBD.getPassword());
						// client.setPicture(fileName);
						client.setFriendlyDatingInformatio(clientBD.getFriendlyDatingInformatio());
						client.setAcademicDatingInformation(clientBD.getAcademicDatingInformation());
						client.setDatingInformation(clientBD.getDatingInformation());

						client.setProfessionalMeetingInformation(professionalMeeting);

						try {
							// enregistrement dans la zone tampon

							String content1 = "Thanks to create your count in our website \n"
									+ " Now,lick on this link to activate E-mail adress: "
									+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
									+ client.getPseudonym() + "&orientationName=" + orientationName;
							String subject1 = "confirm your E-mail adress";
							// String form="saphirmfogo@gmail.com";V
							MimeMessage msg = new MimeMessage(session);
							/// msg.setFrom(new InternetAddress(form));
							msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
							msg.setSubject(subject1);
							msg.setText(content1);
							msg.setSentDate(new Date());

							Transport transport = session.getTransport("smtp");
							transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
							transport.sendMessage(msg, msg.getAllRecipients());
							transport.close();

							// clientBufferRepository.deleteAll();
							clientBufferRepository.save(client);

							return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());

							logger.error("Unable to create. A Member with name {} already exist",
									client.getPseudonym());
							return new ResponseEntity(new ErrorClass("the email is not validate"),
									HttpStatus.OK);

						}
					}
				} else {

					try {

						// ChooseMeeting chooseMeetingBd
						// =chooseMeetingRepository.findByIdChooseMeeting(idChoose);
						if (chooseMeetingRepository.findByIdChooseMeeting(idChoose) != null) {

							return new ResponseEntity(
									new ErrorClass(
											"this pseudonym is already using, please choose an another own"),
									HttpStatus.OK);
						} else {
							chooseMeeting.setIdChooseMeeting(idChoose);
							chooseMeetingRepository.save(chooseMeeting);

							professionalMeeting.setFirstName(firstName);
							professionalMeeting.setLastName(lastName);
							professionalMeeting.setLevelStudy(levelStudy);
							professionalMeeting.setProfession(profession);

							client.setPseudonym(pseudonym);
							client.setGender(gender);
							client.setBirthDate(birthDate);
							client.setEmailAdress(emailAdress);
							client.setPhoneNumber(phoneNumber);
							client.setPassword(password);
							// client.setPicture(fileName);
							client.setFriendlyDatingInformatio(null);
							client.setAcademicDatingInformation(null);
							client.setDatingInformation(null);

							client.setProfessionalMeetingInformation(professionalMeeting);

							try {
								// enregistrement dans la zone tampon

								String content1 = "Thanks to create your count in our website \n"
										+ " Now,lick on this link to activate E-mail adress: "
										+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
										+ client.getPseudonym() + "&orientationName=" + orientationName;
								String subject1 = "confirm your E-mail adress";
								// String form="saphirmfogo@gmail.com";V
								MimeMessage msg = new MimeMessage(session);
								/// msg.setFrom(new InternetAddress(form));
								msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
								msg.setSubject(subject1);
								msg.setText(content1);
								msg.setSentDate(new Date());

								Transport transport = session.getTransport("smtp");
								transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
								transport.sendMessage(msg, msg.getAllRecipients());
								transport.close();

								// clientBufferRepository.deleteAll();
								clientBufferRepository.save(client);

								return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
							} catch (Exception ex) {
								System.out.println(ex.getMessage());

								logger.error("Unable to create. A Member with name {} already exist",
										client.getPseudonym());
								return new ResponseEntity(new ErrorClass("the email is not validate"),
										HttpStatus.OK);

							}

						}
					} catch (Exception ex) {
						System.out.println(ex.getMessage());

						logger.error("Unable to create. A Member with name {} already exist", client.getPseudonym());
						return new ResponseEntity(new ErrorClass("the email is not validate"),
								HttpStatus.OK);

					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());

				logger.error("Unable to create. A Member with name {} already exist", client.getPseudonym());
				return new ResponseEntity(new ErrorClass("the email is not validate"), HttpStatus.OK);

			}

		} else if (orientationName.equals("Academique")) {

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String schoolName = request.getParameter("schoolName");
			String levelStudy = request.getParameter("levelStudy");

			ChooseMeeting chooseMeeting = new ChooseMeeting();
			MemberBuffer client = new MemberBuffer();
			AcademicDatingInformation academicDatingInformation = new AcademicDatingInformation();

			TypeOfOrientation typeMeeting = typeMeetingRepository.findByMeetingName(orientationName);

			String idTypeOfOrientation = typeMeeting.getId();
			String idChoose = pseudonym + idTypeOfOrientation;

			try {
				// part = request.getPart("picture");
				// String fileName = SAVE_DIR_PICTURE + File.separator + nom;
				// part.write(SAVE_DIR_PICTURE + File.separator + nom);

				// Member clientBD =
				// clientRepository.findByPseudonym(pseudonym);

				if (clientRepository.findByPseudonym(pseudonym) != null) {

					ChooseMeeting chooseMeetingBd = chooseMeetingRepository.findByIdChooseMeeting(idChoose);
					if (chooseMeetingBd != null) {

						return new ResponseEntity(
								new ErrorClass("the email and pseudonym are already created in this type orientation"),
								HttpStatus.OK);
					} else {
						Member clientBD = clientRepository.findByPseudonym(pseudonym);
						chooseMeeting.setIdChooseMeeting(idChoose);
						chooseMeetingRepository.save(chooseMeeting);

						academicDatingInformation.setFirstName(firstName);
						academicDatingInformation.setLastName(lastName);
						academicDatingInformation.setLevelStudy(levelStudy);
						academicDatingInformation.setSchoolName(schoolName);

						client.setPseudonym(clientBD.getPseudonym());
						client.setGender(clientBD.getGender());
						client.setBirthDate(clientBD.getBirthDate());
						client.setEmailAdress(clientBD.getEmailAdress());
						client.setPhoneNumber(clientBD.getPhoneNumber());
						client.setPassword(clientBD.getPassword());
						// client.setPicture(fileName);
						client.setFriendlyDatingInformatio(clientBD.getFriendlyDatingInformatio());
						client.setProfessionalMeetingInformation(clientBD.getProfessionalMeetingInformation());
						client.setDatingInformation(clientBD.getDatingInformation());

						client.setAcademicDatingInformation(academicDatingInformation);

						try {
							// enregistrement dans la zone tampon

							String content1 = "Thanks to create your count in our website \n"
									+ " Now,lick on this link to activate E-mail adress: "
									+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
									+ client.getPseudonym() + "&orientationName=" + orientationName;
							String subject1 = "confirm your E-mail adress";
							// String form="saphirmfogo@gmail.com";V
							MimeMessage msg = new MimeMessage(session);
							/// msg.setFrom(new InternetAddress(form));
							msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
							msg.setSubject(subject1);
							msg.setText(content1);
							msg.setSentDate(new Date());

							Transport transport = session.getTransport("smtp");
							transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
							transport.sendMessage(msg, msg.getAllRecipients());
							transport.close();

							// clientBufferRepository.deleteAll();
							clientBufferRepository.save(client);

							return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());

							logger.error("Unable to create. A Member with name {} already exist",
									client.getPseudonym());
							return new ResponseEntity(new ErrorClass("the email is not validate"),
									HttpStatus.OK);

						}
					}
				} else {

					try {

						// ChooseMeeting chooseMeetingBd
						// =chooseMeetingRepository.findByIdChooseMeeting(idChoose);
						if (chooseMeetingRepository.findByIdChooseMeeting(idChoose) != null) {

							return new ResponseEntity(
									new ErrorClass(
											"this pseudonym is already using, please choose an another own"),
									HttpStatus.OK);
						} else {
							chooseMeeting.setIdChooseMeeting(idChoose);
							chooseMeetingRepository.save(chooseMeeting);

							academicDatingInformation.setFirstName(firstName);
							academicDatingInformation.setLastName(lastName);
							academicDatingInformation.setLevelStudy(levelStudy);
							academicDatingInformation.setSchoolName(schoolName);

							client.setPseudonym(pseudonym);
							client.setGender(gender);
							client.setBirthDate(birthDate);
							client.setEmailAdress(emailAdress);
							client.setPhoneNumber(phoneNumber);
							client.setPassword(password);
							// client.setPicture(fileName);
							client.setFriendlyDatingInformatio(null);
							client.setProfessionalMeetingInformation(null);
							client.setDatingInformation(null);

							client.setAcademicDatingInformation(academicDatingInformation);

							try {
								// enregistrement dans la zone tampon

								String content1 = "Thanks to create your count in our website \n"
										+ " Now,lick on this link to activate E-mail adress: "
										+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
										+ client.getPseudonym() + "&orientationName=" + orientationName;
								String subject1 = "confirm your E-mail adress";
								// String form="saphirmfogo@gmail.com";V
								MimeMessage msg = new MimeMessage(session);
								/// msg.setFrom(new InternetAddress(form));
								msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
								msg.setSubject(subject1);
								msg.setText(content1);
								msg.setSentDate(new Date());

								Transport transport = session.getTransport("smtp");
								transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
								transport.sendMessage(msg, msg.getAllRecipients());
								transport.close();

								// clientBufferRepository.deleteAll();
								clientBufferRepository.save(client);

								return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
							} catch (Exception ex) {
								System.out.println(ex.getMessage());

								logger.error("Unable to create. A Member with name {} already exist",
										client.getPseudonym());
								return new ResponseEntity(new ErrorClass("the email is not validate"),
										HttpStatus.OK);

							}

						}
					} catch (Exception ex) {
						System.out.println(ex.getMessage());

						logger.error("Unable to create. A Member with name {} already exist", client.getPseudonym());
						return new ResponseEntity(new ErrorClass("the email is not validate"),
								HttpStatus.OK);

					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());

				logger.error("Unable to create. A Member with name {} already exist", client.getPseudonym());
				return new ResponseEntity(new ErrorClass("the email is not validate"), HttpStatus.OK);

			}

		} else if (orientationName.equals("Amicale")) {

			String name = request.getParameter("name");

			ChooseMeeting chooseMeeting = new ChooseMeeting();
			MemberBuffer client = new MemberBuffer();
			FriendlyDatingInformation friendlyDatingInformation = new FriendlyDatingInformation();

			TypeOfOrientation typeMeeting = typeMeetingRepository.findByMeetingName(orientationName);

			String idTypeOfOrientation = typeMeeting.getId();
			String idChoose = pseudonym + idTypeOfOrientation;

			try {
				// part = request.getPart("picture");
				// String fileName = SAVE_DIR_PICTURE + File.separator + nom;
				// part.write(SAVE_DIR_PICTURE + File.separator + nom);

				// Member clientBD =
				// clientRepository.findByPseudonym(pseudonym);

				if (clientRepository.findByPseudonym(pseudonym) != null) {

					ChooseMeeting chooseMeetingBd = chooseMeetingRepository.findByIdChooseMeeting(idChoose);
					if (chooseMeetingBd != null) {

						return new ResponseEntity(
								new ErrorClass("the email and pseudonym are already created in this type orientation"),
								HttpStatus.OK);
					} else {
						Member clientBD = clientRepository.findByPseudonym(pseudonym);
						chooseMeeting.setIdChooseMeeting(idChoose);
						chooseMeetingRepository.save(chooseMeeting);

						friendlyDatingInformation.setName(name);

						client.setPseudonym(clientBD.getPseudonym());
						client.setGender(clientBD.getGender());
						client.setBirthDate(clientBD.getBirthDate());
						client.setEmailAdress(clientBD.getEmailAdress());
						client.setPhoneNumber(clientBD.getPhoneNumber());
						client.setPassword(clientBD.getPassword());
						// client.setPicture(fileName);
						client.setAcademicDatingInformation(clientBD.getAcademicDatingInformation());
						client.setProfessionalMeetingInformation(clientBD.getProfessionalMeetingInformation());
						client.setDatingInformation(clientBD.getDatingInformation());

						client.setFriendlyDatingInformatio(friendlyDatingInformation);

						try {
							// enregistrement dans la zone tampon

							String content1 = "Thanks to create your count in our website \n"
									+ " Now,lick on this link to activate E-mail adress: "
									+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
									+ client.getPseudonym() + "&orientationName=" + orientationName;
							String subject1 = "confirm your E-mail adress";
							// String form="saphirmfogo@gmail.com";V
							MimeMessage msg = new MimeMessage(session);
							/// msg.setFrom(new InternetAddress(form));
							msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
							msg.setSubject(subject1);
							msg.setText(content1);
							msg.setSentDate(new Date());

							Transport transport = session.getTransport("smtp");
							transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
							transport.sendMessage(msg, msg.getAllRecipients());
							transport.close();

							// clientBufferRepository.deleteAll();
							clientBufferRepository.save(client);

							return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());

							logger.error("Unable to create. A Member with name {} already exist",
									client.getPseudonym());
							return new ResponseEntity(new ErrorClass("the email is not validate"),
									HttpStatus.OK);

						}
					}
				} else {

					try {

						// ChooseMeeting chooseMeetingBd
						// =chooseMeetingRepository.findByIdChooseMeeting(idChoose);
						if (chooseMeetingRepository.findByIdChooseMeeting(idChoose) != null) {

							return new ResponseEntity(
									new ErrorClass(
											"this pseudonym is already using, please choose an another own"),
									HttpStatus.OK);
						} else {
							chooseMeeting.setIdChooseMeeting(idChoose);
							chooseMeetingRepository.save(chooseMeeting);

							friendlyDatingInformation.setName(name);

							client.setPseudonym(pseudonym);
							client.setGender(gender);
							client.setBirthDate(birthDate);
							client.setEmailAdress(emailAdress);
							client.setPhoneNumber(phoneNumber);
							client.setPassword(password);
							// client.setPicture(fileName);
							client.setAcademicDatingInformation(null);
							client.setProfessionalMeetingInformation(null);
							client.setDatingInformation(null);

							client.setFriendlyDatingInformatio(friendlyDatingInformation);

							try {
								// enregistrement dans la zone tampon

								String content1 = "Thanks to create your count in our website \n"
										+ " Now,lick on this link to activate E-mail adress: "
										+ "http://localhost:8091/rencontre/InternetSurfer/confirmRegistration?user="
										+ client.getPseudonym() + "&orientationName=" + orientationName;
								String subject1 = "confirm your E-mail adress";
								// String form="saphirmfogo@gmail.com";V
								MimeMessage msg = new MimeMessage(session);
								/// msg.setFrom(new InternetAddress(form));
								msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
								msg.setSubject(subject1);
								msg.setText(content1);
								msg.setSentDate(new Date());

								Transport transport = session.getTransport("smtp");
								transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "meilleure");
								transport.sendMessage(msg, msg.getAllRecipients());
								transport.close();

								// clientBufferRepository.deleteAll();
								clientBufferRepository.save(client);

								return new ResponseEntity<MemberBuffer>(client, HttpStatus.CREATED);
							} catch (Exception ex) {
								System.out.println(ex.getMessage());

								logger.error("Unable to create. A Member with name {} already exist",
										client.getPseudonym());
								return new ResponseEntity(new ErrorClass("the email is not validate"),
										HttpStatus.OK);

							}

						}
					} catch (Exception ex) {
						System.out.println(ex.getMessage());

						logger.error("Unable to create. A Member with name {} already exist", client.getPseudonym());
						return new ResponseEntity(new ErrorClass("the email is not validate"),
								HttpStatus.OK);

					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());

				logger.error("Unable to create. A Member with name {} already exist", client.getPseudonym());
				return new ResponseEntity(new ErrorClass("the email is not validate"), HttpStatus.OK);

			}

		}
		return new ResponseEntity(new ErrorClass("the type of orientation is not available"), HttpStatus.OK);
	}

	// *************************************************************************************************************
	// ******************************************************************************/
	// ***********************methode d'ajout d'un nouveau
	// client******************************//
	// ******************************************************************************//
	// methode pour le choix du type d'orientation en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/choiceOfTypeOfOrientation", method = RequestMethod.GET)
	public ResponseEntity<?> choiceOfTypeOfOrientationGet(HttpServletRequest request) {

		return null;

	}

	/*/ methode pour le choix du type d'orientation en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/choiceOfTypeOfOrientation", method = RequestMethod.POST)
	public ResponseEntity<?> choiceOfTypeOfOrientationPost(HttpServletRequest request) {

		// recuperation des informations du client

		String typeOfOrientation = (String) request.getParameter("typeOfOrientation");
		String emailAddress = request.getParameter("emailAdress");

		Client client = new Client(emailAddress, typeOfOrientation);
		logger.info("enregistrement du type d'orientation choisi" + " par le client d'adresse email {}", emailAddress);
		if (clientRepository.findByEmailAddress(emailAddress) != null) {
			logger.error("le client d'adresse {} est deja enregistré" + " dans la base de donnees", emailAddress);
			return new ResponseEntity(
					new ErrorClass(
							"le client d'adresse " + emailAddress + " est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}

		clientRepository.save(client);
		return new ResponseEntity(new SuccessClass("enregistrement " + "effectué avec succès", client), HttpStatus.OK);
	}*/

	// methode d'ajout d'un nouveau client en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public ResponseEntity<?> addClientGet(HttpServletRequest request) {

		return null;
	}

	// methode d'ajout d'un nouveau client en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ResponseEntity<?> addClientPost(HttpServletRequest request) {

		// recuperation des informations du client

		String firstNameCustomer = (String) request.getParameter("firstNameCustomer");
		String lastNameCustomer = (String) request.getParameter("lastNameCustomer");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String emailAddress = (String) request.getParameter("emailAddress");
		String password = (String) request.getParameter("password");
		// clientRepository.deleteAll();
		// instanciation du client à ajouter

		Client client = new Client();
		NewsletterConcern newsletterConcern = new NewsletterConcern(emailAddress);

		// action a menner apres reception des informations

		client.setFirstNameCustomer(firstNameCustomer);
		client.setLastNameCustomer(lastNameCustomer);
		client.setPhoneNumber(phoneNumber);
		client.setPassword(password);
		client.setEmailAddress(emailAddress);

		logger.info("enregistrement du client {}", client);
		if (clientRepository.findByEmailAddress(emailAddress) != null) {
			logger.error("le client {} est deja enregistré dans la base de donnees", client);
			return new ResponseEntity(new ErrorClass("le client est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}
		clientRepository.save(client);
		newsletterConcernRepository.save(newsletterConcern);
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		// properties.put("mail.smtp.host", "smtp-relay.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "false");
		properties.put("mail.smtp.connectiontimeout", "5000");
		properties.put("mail.smtp.timeout", "5000");
		properties.put("mail.smtp.writetimeout", "5000");
		Session session = Session.getInstance(properties, null);

		String content1 = "Thanks to create your count in our " + "website! your password is " + client.getPassword();
		String subject1 = "inscription sur le site d'orientation bocobi2 reussie!!!";
		// String form="saphirmfogo@gmail.com";
		MimeMessage msg = new MimeMessage(session);
		/// msg.setFrom(new InternetAddress(form));
		try {
			msg.setRecipients(MimeMessage.RecipientType.TO, emailAddress);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setSubject(subject1);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setText(content1);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setSentDate(new Date());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
		} catch (NoSuchProviderException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			transport.connect("smtp.gmail.com", "tialoinnocent@gmail.com", "28640000");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity(new SuccessClass("enregistrement " + "effectué avec succès", client),
				HttpStatus.CREATED);
	}
	// **************************************************************************************************************
	// ******************************************************************************//
	// ***********************methode d'inscription à la news
	// letter****************//
	// ******************************************************************************//

	// methode d'inscription à la newsletter en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscriptionToNewsletter", method = RequestMethod.GET)
	public ResponseEntity<?> inscriptionToNewsLetterGet(HttpServletRequest request) {

		// recuperation des informations du client
		String newsletterConcernEmail = (String) request.getParameter("newsletterConcernEmail");

		NewsletterConcern newsletterConcern = new NewsletterConcern(newsletterConcernEmail);
		logger.info("enregistrement de l'adresse email {}", newsletterConcernEmail);
		if (newsletterConcernRepository.findByNewsletterConcernEmail(newsletterConcernEmail) != null) {
			logger.error("l'adresse {} est deja enregistré dans la base de donnees", newsletterConcernEmail);
			return new ResponseEntity(
					new ErrorClass(
							"l'adresse " + newsletterConcernEmail + " est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}

		newsletterConcernRepository.save(newsletterConcern);
		return new ResponseEntity(new SuccessClass("enregistrement " + "effectué avec succès"), HttpStatus.OK);
	}

	// methode d'inscripotion à la newsletter en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscriptionToNewsletter", method = RequestMethod.POST)
	public ResponseEntity<?> inscriptionToNewsLetterPost(HttpServletRequest request) {

		// recuperation des informations du client
		String newsletterConcernEmail = (String) request.getParameter("newsletterConcernEmail");

		NewsletterConcern newsletterConcern = new NewsletterConcern(newsletterConcernEmail);

		logger.info("enregistrement de l'adresse email {}", newsletterConcernEmail);
		if (newsletterConcernRepository.findByNewsletterConcernEmail(newsletterConcernEmail) != null) {
			logger.error("l'adresse {} est deja enregistré dans la base de donnees", newsletterConcernEmail);
			return new ResponseEntity(
					new ErrorClass(
							"l'adresse " + newsletterConcernEmail + " est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}
		newsletterConcernRepository.save(newsletterConcern);
		return new ResponseEntity(new SuccessClass("enregistrement " + "effectué avec succès"), HttpStatus.OK);
	}

}
