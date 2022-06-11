package com.adriano.helpedesk;

import com.adriano.helpedesk.domain.Chamado;
import com.adriano.helpedesk.domain.Cliente;
import com.adriano.helpedesk.domain.Tecnico;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.domain.enums.Perfil;
import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpedeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpedeskApplication.class, args);
	}
}
