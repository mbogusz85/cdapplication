package pl.dominisz;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * http://dominisz.pl
 * 22.12.2017
 */
@Data
@AllArgsConstructor
public class MenuItem {

    private String message;
    private Runnable action;

}
