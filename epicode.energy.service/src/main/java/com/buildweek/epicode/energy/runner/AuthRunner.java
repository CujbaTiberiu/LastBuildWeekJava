package com.buildweek.epicode.energy.runner;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.buildweek.epicode.energy.entity.ERole;
import com.buildweek.epicode.energy.entity.Role;
import com.buildweek.epicode.energy.model.Comune;
import com.buildweek.epicode.energy.model.ComuneDTOcsv;
import com.buildweek.epicode.energy.model.Provincia;
import com.buildweek.epicode.energy.repository.ComuneRepository;
import com.buildweek.epicode.energy.repository.RoleRepository;
import com.buildweek.epicode.energy.repository.UserRepository;
import com.buildweek.epicode.energy.service.AuthService;
import com.buildweek.epicode.energy.service.ComuneService;
import com.buildweek.epicode.energy.service.ProvinciaService;
import com.opencsv.bean.CsvToBeanBuilder;




@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	@Autowired ComuneService comuneService;
	@Autowired ProvinciaService provService;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		// Metodo da lanciare solo la prima volta
		// Serve per salvare i ruoli nel DB
//		setRoleDefault();
	
		saveProvinceDb();
		//CSVReaderWriter();
		
		saveComuniDb();
	}
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
		
//		adminRole = new HashSet<Role>();
//		adminRole.add(admin);
//		adminRole.add(moderator);
//		adminRole.add(user);
//		
//		moderatorRole = new HashSet<Role>();
//		moderatorRole.add(moderator);
//		moderatorRole.add(user);
//		
//		userRole = new HashSet<Role>();
//		userRole.add(user);
	}
	
	private void saveProvinceDb() throws IllegalStateException, IOException {
		List<Provincia> listaProvince = new CsvToBeanBuilder<Provincia>(new FileReader("../epicode.energy.service/src/main/resources/csv/province-italiane.csv")).withSeparator(';').withType(Provincia.class).build().parse();
		for(int i = 1; i<listaProvince.size();i++) {
		provService.save(listaProvince.get(i));
		System.out.println(listaProvince.get(i));
		}
		}
	

private void saveComuniDb() throws IllegalStateException, IOException {
	List<ComuneDTOcsv> listaComuniDTO = new CsvToBeanBuilder<ComuneDTOcsv>(new FileReader("../epicode.energy.service/src/main/resources/csv/comuni-italiani2.csv")).withSeparator(';').withType(ComuneDTOcsv.class).build().parse();


	
	for(int i = 1; i<listaComuniDTO.size();i++) {
		
Comune comune = new Comune();
comune.setNome(listaComuniDTO.get(i).getNome());
comune.setProvincia(provService.FindByName(listaComuniDTO.get(i).getProvincia()));
comuneService.add(comune);
	System.out.println(comune);
	}
	}
}

	
	
	


