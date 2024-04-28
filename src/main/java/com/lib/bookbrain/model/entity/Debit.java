package com.lib.bookbrain.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime returnTime;

public static Debit fromBookAndBorrower(Book book, User user) {
	Debit _d = new Debit();
	{
		_d.setBook(book);
		_d.setCreatedBy(user);
		_d.setUpdatedBy(user);
	}
	return _d;
}
}
