package com.example.Assignment7.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment7.entities.Trainee;
import com.example.Assignment7.exceptions.TraineeNotFoundException;
import com.example.Assignment7.repositories.ITraineeRepository;

@Service
public class TraineeServiceImpl implements ITraineeService {
	
	@Autowired
    private ITraineeRepository repo;
	
	  @Override
	    public Trainee addTrainee(Trainee t) {
	        return repo.save(t);
	    }

	  @Override
	  public void deleteTrainee(int id) {
		    if (!repo.existsById(id)) {
		        throw new TraineeNotFoundException("Trainee with id "+id+" does not exist.");
		    }
		    repo.deleteById(id);
		}

	    @Override
	    public Trainee updateTrainee(int id, Trainee t) {
	    	Trainee existing = repo.findById(id)
	    	        .orElseThrow(() -> new TraineeNotFoundException("Trainee not found"));

	    	existing.setTraineeName(t.getTraineeName());
	    	existing.setTraineeDomain(t.getTraineeDomain());
	    	existing.setTraineeLocation(t.getTraineeLocation());

	    	return repo.save(existing);
	    }

	   

	    @Override
	    public List<Trainee> getAllTrainees() {
	        return repo.findAll();
	    }

	    @Override
	    public Trainee findByTraineeId(int id) {
	        return repo.findById(id)
	            .orElseThrow(() -> new TraineeNotFoundException("Trainee not found with id: " + id));
	    }

		@Override
		public Trainee findByTraineeName(String name) {
			return repo.findByTraineeName(name)
					.orElseThrow(()-> new TraineeNotFoundException("Trainee not found with name: " + name) );
		
		}
	
	

}



















