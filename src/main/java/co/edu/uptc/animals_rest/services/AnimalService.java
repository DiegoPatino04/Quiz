package co.edu.uptc.animals_rest.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.animals_rest.exception.InvalidRangeException;
import co.edu.uptc.animals_rest.models.Animal;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

@Service
public class AnimalService {
    private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);
    @Value("${animal.file.path}")
    private String filePath;

    public List<Animal> getAnimalInRange(int from, int to) throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> animales = new ArrayList<>();

        if (from < 0 || to >= listAnimal.size() || from > to) {
            logger.warn("Invalid range: Please check the provided indices. Range: 0 to {}", listAnimal.size());
            throw new InvalidRangeException("Invalid range: Please check the provided indices.");
        }

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String categoria = parts[0].trim();
                String nombre = parts[1].trim();
                animales.add(new Animal(nombre, categoria));
            }
        }

        return animales.subList(from, to + 1);
    }

    public List<Animal> getAnimalAll() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> animales = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String category = parts[0].trim();
                String name = parts[1].trim();
                animales.add(new Animal(name, category));
            }
        }

        return animales;
    }

    public List<Animal> getCategorymammals() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> mammals = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2 && "Mamíferos".equals(parts[0].trim())) {
                                                                            
                String name = parts[1].trim(); 
                mammals.add(new Animal(name, "Mamíferos"));
            }
        }

        return mammals;
    }

    public List<Animal> getCategorybirds() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> birds = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2 && "Aves".equals(parts[0].trim())) { 
                String name = parts[1].trim(); 
                birds.add(new Animal(name, "Aves"));
            }
        }

        return birds;
    }

    public List<Animal> getCategoryreptiles() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> reptiles = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2 && "Reptiles".equals(parts[0].trim())) {
                                                                          
                String name = parts[1].trim(); 
                reptiles.add(new Animal(name, "Reptiles"));
            }
        }

        return reptiles;
    }

    public List<Animal> getCategoryamphibians() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> amphibians = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2 && "Anfibios".equals(parts[0].trim())) { 
                                                                          
                String name = parts[1].trim(); 
                amphibians.add(new Animal(name, "Anfibios"));
            }
        }

        return amphibians;
    }

    public List<Animal> getCategoryfish() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> fish = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2 && "Peces".equals(parts[0].trim())) { 
                                                                          
                String name = parts[1].trim(); 
                fish.add(new Animal(name, "Peces"));
            }
        }

        return fish;
    }
    
    public List<Animal> getCategoryinsects() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> insects = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2 && "Insectos".equals(parts[0].trim())) { 
                                                                          
                String name = parts[1].trim(); 
                insects.add(new Animal(name, "Insectos"));
            }
        }

        return insects;
    }

    public List<Animal> getCategoryinvertebrates() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> invertebrates = new ArrayList<>();

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2 && "Invertebrados".equals(parts[0].trim())) { 
                                                                         
                String name = parts[1].trim(); 
                invertebrates.add(new Animal(name, "Invertebrados"));
            }
        }

        return invertebrates;
    }

    public List<Animal> getAnimalsByMaxNameLength(int maxLength) throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> filteredAnimals = new ArrayList<>();
    
        if (maxLength < 0) {
            logger.warn("Invalid length: maxLength must be >= 0.");
            throw new IllegalArgumentException("Invalid length: maxLength must be >= 0.");
        }
    
        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String category = parts[0].trim();
                String name = parts[1].trim();
    
                // Verificar si la longitud del nombre es menor o igual al maxLength
                if (name.length() <= maxLength) {
                    filteredAnimals.add(new Animal(name, category));
                }
            }
        }
    
        return filteredAnimals;
    }
    
    
}
