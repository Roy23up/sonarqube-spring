package com.mx.demo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRender<T> {

	private String url;
	private Page<T> page;
	private int totalPaginas;
	
	private int numElementos;
	private int paginaActual;
	
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		numElementos = 6;
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;
		
		int desde, hasta;
		
		if (totalPaginas <= numElementos) {
			desde = 1;
			hasta = totalPaginas;
		} else {
			if (paginaActual <= numElementos) {
				desde = 1;
				hasta = numElementos;
			} else if (paginaActual >= totalPaginas - numElementos/2) {
				desde = totalPaginas - numElementos + 1;
				hasta = numElementos;
			}else {
				desde = paginaActual - numElementos/2; 
				hasta = numElementos;
			}
		}
		
		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i) );
			
		}		
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean ishasPrevious() {
		return page.hasPrevious();
	}
	
}
