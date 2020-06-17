package com.processos;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mapping.AccessOptions.GetOptions.GetNulls;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.processos.dominio.Classe;
import com.processos.dominio.Parte;
import com.processos.dominio.ParteProcesso;
import com.processos.dominio.Processo;
import com.processos.repository.ClasseRepository;
import com.processos.repository.ParteProcessoRepository;
import com.processos.repository.ParteRepository;
import com.processos.repository.ProcessoRepository;
import com.processos.service.ProcessoService;

@SpringBootApplication
public class ProcessosApplication implements CommandLineRunner {

	@Autowired
	private ClasseRepository repo;
	
	@Autowired
	private ProcessoService processoService;
	
	@Autowired
	private ProcessoRepository processoRepo;
	
	@Autowired
	private ParteRepository parteRepo;
	
	@Autowired
	private ParteProcessoRepository parteProcessoRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProcessosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY HH:mm");
		
		Parte parte1 = new Parte(null, "Joao", sdf.parse("15-05-2020 12:00"), "01112245678", "Criminal");
		Parte parte2 = new Parte(null, "Joao", sdf.parse("15-05-2020 12:00"), "01112245678", "Criminal");
		parteRepo.saveAll(Arrays.asList(parte1, parte2));
		
		
	
		Processo processo1 = new Processo(null, "0000100-16.2020.811", sdf.parse("15-05-2020 12:00"), sdf.parse("15-05-2020 12:00") );
		Processo processo2 = new Processo(null,  "0000100-16.2020.811", sdf.parse("15-05-2020 12:00"), sdf.parse("15-05-2020 12:00") );
		
		ParteProcesso pp1 = new ParteProcesso(processo1, parte1);
		ParteProcesso pp2 = new ParteProcesso(processo2, parte2);
		
		processo1.getParteProcessos().add(pp1);
		processo2.getParteProcessos().add(pp2);
		
		parte1.getParteProcessos().addAll(Arrays.asList(pp1));
		
		
		processoRepo.saveAll(Arrays.asList(processo1, processo2));
		
		parteProcessoRepo.saveAll(Arrays.asList(pp1,pp2));
		
		
		Reader reader = Files.newBufferedReader(Paths.get("TABELA_DE_CLASSES_ATIVAS.csv"));

		CsvToBean<Classe> ClasseCsv = new CsvToBeanBuilder<Classe>(reader).withType(Classe.class).build();

		List<Classe> classes = ClasseCsv.parse();
		Classe novaClasse = new Classe();

		for (Classe classe : classes) {

			novaClasse.setId(classe.getId());
			novaClasse.setId_cnj(classe.getId_cnj());
			novaClasse.setDs_classe(classe.getDs_classe());
			novaClasse.setSigla(classe.getSigla());
			novaClasse.setTipo(classe.getTipo());

			System.out.println(novaClasse);

			repo.saveAll(Arrays.asList(novaClasse));

			/*
			 * String valorFormatado = new DecimalFormat("0000000").format(100);
			 * System.out.println("Valor formatado "+ valorFormatado );
			 * 
			 * 
			 * Date data = new Date(); System.out.println("Data Agora: "+data);
			 * 
			 * 
			 * Calendar c = Calendar.getInstance();
			 * System.out.println("Data e Hora atual: "+c.getTime());
			 * System.out.println("Mês: "+c.get(Calendar.MONTH));
			 * System.out.println("Ano: "+c.get(Calendar.YEAR));
			 * 
			 * String codigoProcesso =
			 * valorFormatado+"-"+c.get(Calendar.MONTH)+"."+c.get(Calendar.YEAR);
			 * System.out.println("Numero do Processo "+codigoProcesso+".811");
			 */
			
//			Integer valorAformatar = 100;
//			
//			String valorFormatado = new DecimalFormat("0000000").format(valorAformatar);
//			//System.out.println("Valor formatado "+ valorFormatado );
//			Calendar c = Calendar.getInstance();
//			//String codigoProcesso = valorFormatado+"-"+c.get(Calendar.MONTH)+"."+c.get(Calendar.YEAR);
//		
//			
//			 String numeroProcesso = Integer.parseInt( valorFormatado)+"-"+c.get(Calendar.MONTH)+"."+c.get(Calendar.YEAR)+"811";
//		
//			 System.out.println("Valor formatado "+ numeroProcesso );
//			 
			// private static 
			 
		}

	}
}
