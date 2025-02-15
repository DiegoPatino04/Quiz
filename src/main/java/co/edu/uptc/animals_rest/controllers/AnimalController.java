package co.edu.uptc.animals_rest.controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.animals_rest.models.Animal;
import co.edu.uptc.animals_rest.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);

    @Autowired
    private AnimalService animalService;

    @GetMapping("/all")
    public List<Animal> getAnimalAll() throws IOException {
        logger.info("getAnimalAll called");
        return animalService.getAnimalAll();
    }

    @GetMapping("/range")
    public List<Animal> getAnimal(@RequestParam int from, @RequestParam int to) throws IOException {
        logger.info("getAnimal called with parameters: from = {}, to = {}", from, to);
        return animalService.getAnimalInRange(from, to);
    }

       @GetMapping("/name-length/{maxLength}")
    public List<Animal> getAnimalsByMaxLength(@PathVariable int maxLength) throws IOException {
        logger.info("Fetching animals with names shorter than {} characters", maxLength);
        return animalService.getAnimalsByMaxNameLength(maxLength);
    }

    @GetMapping("/mammals")
    public List<Animal> getMammals() throws IOException {
        logger.info("getMammals called");
        return animalService.getCategorymammals();
    }

    @GetMapping("/birds")
    public List<Animal> getBirds() throws IOException {
        logger.info("getBirds called");
        return animalService.getCategorybirds();
    }

    @GetMapping("/reptiles")
    public List<Animal> getreptiles() throws IOException {
        logger.info("getReptiles called");
        return animalService.getCategoryreptiles();
    }

    @GetMapping("/amphibians")
    public List<Animal> getamphibians() throws IOException {
        logger.info("getAmphibians called");
        return animalService.getCategoryamphibians();
    }

    @GetMapping("/fish")
    public List<Animal> getfish() throws IOException {
        logger.info("getFish called");
        return animalService.getCategoryfish();
    }

    @GetMapping("/insects")
    public List<Animal> getinsects() throws IOException {
        logger.info("getInsects called");
        return animalService.getCategoryinsects();
    }

    @GetMapping("/invertebrates")
    public List<Animal> getinvertebrates() throws IOException {
        logger.info("getInvertebratescalled");
        return animalService.getCategoryinvertebrates();
    }
}
