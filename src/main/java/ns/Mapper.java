package ns;

import java.util.UUID;

import org.springframework.stereotype.Component;

import ns.controllers.viewmodel.NoteViewModel;
import ns.controllers.viewmodel.NotebookViewModel;
import ns.controllers.viewmodel.UserViewModel;
import ns.db.NotebookRepository;
import ns.models.Note;
import ns.models.Notebook;
import ns.models.User;

@Component
public class Mapper {
	private NotebookRepository notebookRepository;

	public Mapper(NotebookRepository notebookRepository) {
		this.notebookRepository = notebookRepository;
	}

	public NoteViewModel convertToNoteViewModel(Note entity) {
		var viewModel = new NoteViewModel();
		viewModel.setTitle(entity.getTitle());
		viewModel.setId(entity.getId().toString());
		viewModel.setLastModifiedOn(entity.getLastModifiedOn());
		viewModel.setText(entity.getText());
		viewModel.setNotebookId(entity.getNotebook().getId().toString());

		return viewModel;
	}

	public Note convertToNoteEntity(NoteViewModel viewModel) {
		var notebook = this.notebookRepository.findById(UUID.fromString(viewModel.getNotebookId())).get();
		var entity = new Note(viewModel.getId(), viewModel.getTitle(), viewModel.getText(), notebook);

		return entity;
	}

	public NotebookViewModel convertToNotebookViewModel(Notebook entity) {
		var viewModel = new NotebookViewModel();
		viewModel.setId(entity.getId().toString());
		viewModel.setName(entity.getName());
		viewModel.setNbNotes(entity.getNotes().size());

		return viewModel;
	}

	public Notebook convertToNotebookEntity(NotebookViewModel viewModel) {
		var entity = new Notebook(viewModel.getId(), viewModel.getName());

		return entity;
	}

	public UserViewModel convertToUserViewModel(User entity) {

		var viewModel = new UserViewModel();

		viewModel.setId(entity.getId().toString());
		viewModel.setFirstName(entity.getFirstName());
		viewModel.setLastName(entity.getLastName());
		viewModel.setUsername(entity.getUsername());
		viewModel.setPassword(entity.getPassword());
		viewModel.setEmail(entity.getEmail());

		return viewModel;
	}

	public User convertToUserEntity(UserViewModel viewModel) {
		var entity = new User(viewModel.getId(), viewModel.getFirstName(), viewModel.getLastName(),
				viewModel.getUsername(), viewModel.getPassword(), viewModel.getEmail());
		return entity;
	}
}
