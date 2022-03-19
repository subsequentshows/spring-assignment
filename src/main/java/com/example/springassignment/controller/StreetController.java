package com.example.springassignment.controller;

import com.example.springassignment.entity.Street;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetController {
    private static ArrayList<Street> listStreet;
    static {
        listStreet = new ArrayList<>();
        listStreet.add(new Street(1, "Nguyen Trai", "Thanh Xuan", 1995, "haha", 1));
        listStreet.add(new Street(1, "Nguyen Trai2", "Thanh Xuan", 1995, "haha", 1));
        listStreet.add(new Street(1, "Nguyen Trai3", "Thanh Xuan", 1995, "haha", 1));
        listStreet.add(new Street(1, "Nguyen Trai4", "Thanh Xuan", 1995, "haha", 1));
        listStreet.add(new Street(1, "Nguyen Trai5", "Thanh Xuan", 1995, "haha", 1));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Street> getStreet() {
        return listStreet;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Street getDetail(@PathVariable int id) {
        Street street = null;
        for (int i = 0; i < listStreet.size(); i++) {
            if(listStreet.get(i).getId() == id) {
                street = listStreet.get(i);
                break;
            }
        }
        return street ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Street create(@RequestBody Street street) {
        listStreet.add(street);
        return street;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Street update(@PathVariable int id, @RequestBody Street updateStreet) {
        Street street = null;
        for (int i = 0; i < listStreet.size(); i++) {
            if(listStreet.get(i).getId() == id) {
                street = listStreet.get(i);
                break;
            }
        }
        if (street !=null) {
            street.setName(updateStreet.getName());
            street.setWard(updateStreet.getWard());
            street.setStatus(updateStreet.getStatus());
        }
        return street ;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        int streetIndex = -1;
        for (int i = 0; i < listStreet.size(); i++) {
            if(listStreet.get(i).getId() == id) {
                streetIndex = i;

            }
        }
        if(streetIndex == - 1) {
            return false;
        }

        listStreet.remove(streetIndex);
        return true;
    }





}
