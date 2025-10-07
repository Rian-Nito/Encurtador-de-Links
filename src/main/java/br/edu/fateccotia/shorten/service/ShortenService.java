package br.edu.fateccotia.shorten.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.edu.fateccotia.shorten.entity.Code;
import br.edu.fateccotia.shorten.repository.ShortenRepository;

@Service
public class ShortenService {

	private final Random random = new Random();
	private final ShortenRepository shortenRepository;
	
	
    public ShortenService(ShortenRepository shortenRepository) {
        this.shortenRepository = shortenRepository;
    }
	
	public Code shorten(String originalUrl) {
	  String finalKey;
	  
	  do {
		  finalKey = generateRandomCode();
	  } while (shortenRepository.existsByCode(finalKey));
	  
	  Code newCode = new Code();
	  newCode.setCode(finalKey);
	  newCode.setOriginalUrl(originalUrl);
	  
	  return shortenRepository.save(newCode);
	}
	  private String generateRandomCode() {
	        StringBuilder keyBuilder = new StringBuilder();
	        while (keyBuilder.length() < 6) {
	            int n = random.nextInt(65, 123);
	            if ((n >= 65 && n <= 90) || (n >= 97 && n <= 122)) {
	                keyBuilder.append((char) n);
	            }
	        }
	        return keyBuilder.toString();
	    }
	  public Optional<Code> findByCode(String code) {
	        return shortenRepository.findByCode(code);
	    }

 }