package ej.sample.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

/**
 * Created by blesu on 2017-02-23.
 */
@RestController
@RequestMapping("/rest")
public class TodoController {

	@RequestMapping(value = "/todo.json", method = RequestMethod.GET)
	public ResponseEntity<ModelMap> execute(ModelMap model) throws Exception {
		HttpStatus stat = HttpStatus.OK;

		List<Item> itemList = new ArrayList<>();

		Item item = new Item();
		item.setAction("Buy flower");
		item.setDone(false);
		itemList.add(item);

		item = new Item();
		item.setAction("Get Shoes");
		item.setDone(false);
		itemList.add(item);

		item = new Item();
		item.setAction("Collect Tickets");
		item.setDone(true);
		itemList.add(item);

		item = new Item();
		item.setAction("Call joe");
		item.setDone(false);
		itemList.add(item);

		model.addAttribute("items", itemList);

		return new ResponseEntity<>(model, stat);
	}

	@Data
	private class Item {
		private String action;
		private boolean done;
	}
}
