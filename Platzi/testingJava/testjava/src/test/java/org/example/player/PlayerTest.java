package org.example.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void winner() {
        // dice sumilado
        Dice dice = Mockito.mock(Dice.class);

        // Cuando se llama al metodo rol, va a devolver un dos, estamos forzando el resultado
        Mockito.when(dice.rol()).thenReturn(2);

        Player player = new Player(dice, 5);
        assertFalse(player.play());
    }

    @Test
    public void looses() {
        // dice sumilado
        Dice dice = Mockito.mock(Dice.class);

        // Cuando se llama al metodo rol, va a devolver un dos, estamos forzando el resultado
        Mockito.when(dice.rol()).thenReturn(4);

        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}