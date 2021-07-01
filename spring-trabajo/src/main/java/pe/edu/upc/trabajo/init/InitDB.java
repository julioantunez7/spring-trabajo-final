package pe.edu.upc.trabajo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Cliente;
import pe.edu.upc.trabajo.model.entity.User;
import pe.edu.upc.trabajo.model.repository.ClienteRepository;
import pe.edu.upc.trabajo.model.repository.UserRepository;

@Service
public class InitDB implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
	// SOLO DESBLOQUEAR CUANDO SE CREEN LOS USUARIOS DE FORMA MANUAL	
	/*
		Cliente clienteAntunez = null;
		Cliente clientePerez = null;

		clienteAntunez = clienteRepository.findById(3).get();
		clientePerez = clienteRepository.findById(4).get();
	
		User antunez = new User();
		
		antunez.setCliente(clienteAntunez);
		clienteAntunez.setUser(antunez);
		
		antunez.setId(3);
		antunez.setUsername("jantunez");
		antunez.setPassword(bcpe.encode("antunez"));
		antunez.setEnable(true);
		
		User perez = new User();
		
		perez.setCliente(clientePerez);
		clientePerez.setUser(perez);
		
		perez.setId(4);
		perez.setUsername("jperez");
		perez.setPassword(bcpe.encode("perez"));
		perez.setEnable(true);
	
		// ROLE -> Segmento objetivo
		antunez.addAuthority("ROLE_CUSTOMER");
		perez.addAuthority("ROLE_VETERINARY");
		
		// ACCESS
		perez.addAuthority("ACCESS_VIP");
		perez.addAuthority("ACCESS_VIEW_CUSTOMER");
		perez.addAuthority("ACCESS_MODIFY_CUSTOMER");
		antunez.addAuthority("ACCESS_VIEW_CUSTOMER");
		antunez.addAuthority(ACCESS_NEW_APPOINTMENTS);
		

		userRepository.save(antunez);
		userRepository.save(perez);	*/
	}
}
