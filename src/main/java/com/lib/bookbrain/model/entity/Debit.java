package com.lib.bookbrain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author yunxia
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Debit extends Entity {

/**
 *
 */
private Long id;

/**
 *
 */
private Book book;

/**
 *
 */
private LocalDate returnDeadline;

/**
 *
 */
private LocalDate returnDate;

public static Debit generate(Book book, User user) {
	Debit _d = new Debit();
	{
		_d.setBook(book);
		_d.setCreatedBy(user);
	}
	return _d;
}
}
