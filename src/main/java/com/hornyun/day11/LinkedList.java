package com.hornyun.day11;

import lombok.Data;

/**
 * @author hornyun
 * @date 2020/10/26 11:02 PM
 */
@Data
public class LinkedList {
    private Element index;

    public void addElement(Element element) {
        if (index == null) {
            this.index = element;
        }else{
            element.setPre(this.index);
            this.index = element;
        }
    }

    public Element removeLast() {
        if (index != null) {
            Element result = this.index;
            this.index = result.getPre();
            result.setPre(null);
            return result;
        } else {
            return null;
        }
    }
}
