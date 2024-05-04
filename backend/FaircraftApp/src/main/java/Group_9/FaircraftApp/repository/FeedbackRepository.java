package Group_9.FaircraftApp.repository;






import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Group_9.FaircraftApp.model.Feedback;


@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

    // Method to find a user by email
    Feedback findById(long id);

    // Method to check if a user with a specific email exists
    boolean existsById(long id);
}