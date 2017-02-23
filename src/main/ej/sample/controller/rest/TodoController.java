package ej.sample.controller.rest;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by blesu on 2017-02-23.
 */
@RestController
@RequestMapping("/rest")
public class TodoController {

    @RequestMapping(value = "/todo.json", method = RequestMethod.GET)
    public ResponseEntity<ModelMap> execute(ModelMap model) throws Exception {
        HttpStatus stat = HttpStatus.OK;

        Item item = new Item();
        item.setAction("Buy flower");
        item.setDone(false);
        model.addAttribute(item);
        item = new Item();
        item.setAction("Get Shoes");
        item.setDone(false);
        model.addAttribute(item);
        item = new Item();
        item.setAction("Collect Tickets");
        item.setDone(true);
        model.addAttribute(item);
        item = new Item();
        item.setAction("Call joe");
        item.setDone(false);
        model.addAttribute(item);

        return new ResponseEntity<>(model, stat);
    }

    @Data
    private class Item {
        private String action;
        private boolean done;
    }
}
