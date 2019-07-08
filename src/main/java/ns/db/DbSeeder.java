package ns.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ns.models.Note;
import ns.models.Notebook;
import ns.models.User;

@Component
public class DbSeeder implements CommandLineRunner {

	private NotebookRepository notebookRepository;
	private NoteRepository noteRepository;
	private UserRepository userRepository;

	public DbSeeder(NotebookRepository notebookRepository, NoteRepository noteRepository,
			UserRepository userRepository) {

		this.notebookRepository = notebookRepository;
		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

		User johndoe = new User("John", "Doe", "johndoe", "12345", "johndoe@gmail.com");
		User janedoe = new User("Jane", "Doe", "janedoe", "12345", "janedoe@gmail.com");
		User natasasmith = new User("Natasa", "Smith", "natasasmith", "12345", "natasasmith@gmail.com");
		User michaelrich = new User("Michael", "Rich", "michaelrich", "12345", "michaelrich@gmail.com");
		User josephthompson = new User("Joseph", "Thompson", "josephthompson", "12345", "josephthompson@gmail.com");
		User radenkogolic = new User("Radenko", "Golic", "radenkogolic", "12345", "radenkogolic@gmail.com");

		this.userRepository.save(johndoe);
		this.userRepository.save(janedoe);
		this.userRepository.save(natasasmith);
		this.userRepository.save(michaelrich);
		this.userRepository.save(josephthompson);
		this.userRepository.save(radenkogolic);

		/********************************************************************************/

		Notebook firstNotebook = new Notebook("Jovanov Notebook");
		Notebook secondNotebook = new Notebook("Diet plan");
		Notebook thirdNotebook = new Notebook("Natasa's party");
		Notebook fourthNotebook = new Notebook("Velibor");

		this.notebookRepository.save(firstNotebook);
		this.notebookRepository.save(secondNotebook);
		this.notebookRepository.save(thirdNotebook);
		this.notebookRepository.save(fourthNotebook);

		/********************************************************************************/

		Note firstNote = new Note("Jovanov note", "Popiti tablete za pritisak na svakih 8 sati.", firstNotebook);
		Note secondNote = new Note("Detaljan plan dijete", "1. Objasniti ljudima mogucnosti keto dijete",
				secondNotebook);
		Note thirdNote = new Note("Programiranje Nedelja", "Java lekcija za nedelju!", thirdNotebook);
		Note fourthNote = new Note("Kako ostati u ketozi", "Šta jesti da ostaneš u ketozi?", fourthNotebook);
		Note fifthNote = new Note("Radenkov note", "Natočiti gorivo u ponedeljak", firstNotebook);

		this.noteRepository.save(firstNote);
		this.noteRepository.save(secondNote);
		this.noteRepository.save(thirdNote);
		this.noteRepository.save(fourthNote);
		this.noteRepository.save(fifthNote);

	}
}