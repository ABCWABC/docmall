package com.mycomy.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycomy.domain.BoardAttachVO;
import com.mycomy.domain.BoardVO;
import com.mycomy.domain.Criteria;
import com.mycomy.domain.PageDTO;
import com.mycomy.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")
@Controller
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/register")
	public void register() {
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("BoardVO.... " + board);
		
		if(board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}
		service.register(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")  
	public void list(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		
		List<BoardVO> list = service.getListWithPaging(cri);
		model.addAttribute("list", list);
		
		int total = service.getTotalCount(cri);
		
		log.info("total: " + total);
		
		PageDTO pageDTO = new PageDTO(cri, total);
		model.addAttribute("pageMaker", pageDTO);

	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("brd_num") Long brd_num, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get...  " + brd_num);
		BoardVO board = service.get(brd_num);
		model.addAttribute("board", board);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		
		log.info("modify: " + board);
		service.modify(board);
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@PostMapping("/remove")   //   /board/remove
	public String remove(@RequestParam("brd_num") Long brd_num, Criteria cri, RedirectAttributes rttr) {
		
		List<BoardAttachVO> attachList = service.getAttachList(brd_num);
		
		if(service.delete(brd_num)) {
					
			deleteFiles(attachList);
		}
		
		return "redirect:/board/list" + cri.getListLink();
	}
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
		
		if(attachList == null || attachList.size() == 0) {
			return;
		}
		
		log.info(attachList);
		attachList.forEach(attach -> {
			
			try {
				Path file = Paths.get("D:\\Dev\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("D:\\Dev\\upload\\" + attach.getUploadPath() + "\\s_" + attach.getUuid() + "_" + attach.getFileName());
					Files.delete(thumbNail);
				}
			}catch(Exception ex) {
				log.error("delete file ertror: " + ex.getMessage());
			}
		});
	}

	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long brd_num){
		
		ResponseEntity<List<BoardAttachVO>> entity = null;
		entity = new ResponseEntity<List<BoardAttachVO>>(service.getAttachList(brd_num), HttpStatus.OK);
		
		return entity;
	}
}
