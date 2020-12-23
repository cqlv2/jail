package fr.stazi.epsi.spring.boot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.stazi.epsi.spring.boot.entity.Cell;

@Service
public class CellService {

	private CellRepository cellRepo;

	public CellService(CellRepository cellRepo) {
		super();
		this.cellRepo = cellRepo;
	}
	
	public List<Cell> findAll() {
		return cellRepo.findAll();
	}

	public Cell update(Cell entity) {
		
		return cellRepo.save(entity);
	}
}
