package com.cafecostes.cafe.DB;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Car")
@Setter
@Getter
public class Car {
    String name;
    String color;
    private List orders;
    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    public void setColor(String _color) {
        this.color = _color;
    }

    public String getColor() {
        return this.color;
    }

    public Car() {
    }
}

