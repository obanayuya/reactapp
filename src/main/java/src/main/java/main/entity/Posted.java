package src.main.java.main.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Posted {

	private int postedId;
	private String user;
	private String title;
	private String sentence;
	private Timestamp date;
	private String picture;


}

