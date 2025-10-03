package br.edu.fateccotia.shorten.controller;

import java.net.URI; // Importe URI
import java.util.Map;
import java.util.Optional; // Importe Optional

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateccotia.shorten.identity.Code;
import br.edu.fateccotia.shorten.service.ShortenService;

@RestController
@RequestMapping("/shorten")
public class ShortenController {
	@Autowired
	private ShortenService shortenService;
		
	@PostMapping
	public ResponseEntity<Code> shorten(
		@RequestBody Map<String,String> mapa){
		String u = mapa.get("originalUrl");
		Code key = shortenService.shorten(u);
		return ResponseEntity.ok(key);
	}
	
	
	@GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable("code") String code) {
  
        Optional<Code> optionalCode = shortenService.findByCode(code);

        if (optionalCode.isPresent()) {
  
            String originalUrl = optionalCode.get().getOriginalUrl();
            
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(originalUrl));

            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } else {

            return ResponseEntity.notFound().build();
        }
    }
}

