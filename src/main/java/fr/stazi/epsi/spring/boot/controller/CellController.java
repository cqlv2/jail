package fr.stazi.epsi.spring.boot.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.stazi.epsi.spring.boot.entity.Cell;
import fr.stazi.epsi.spring.boot.services.CellService;

@RestController
@RequestMapping("/api/cells")
public class CellController {

	private CellService cellServ;

	public CellController(CellService cellServ) {
		super();
		this.cellServ = cellServ;
	}
	
	@GetMapping
	public List<Cell> getAll() {
		return cellServ.findAll();
	}
	
	
	@PreAuthorize("@securityMethodsService.canManage(#id, principal)")
	@PutMapping("/{id}")
	public Cell update(@PathVariable Long id, @RequestBody Cell entity) {
			return cellServ.update(entity);
	}
	
	
}
