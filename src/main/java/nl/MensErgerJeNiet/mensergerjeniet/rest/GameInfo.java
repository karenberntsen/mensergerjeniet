package nl.MensErgerJeNiet.mensergerjeniet.rest;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameInfo {
	private String id;
	private ArrayList<String> playerNames;
}
