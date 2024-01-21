package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.BaseEntity;
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
public class Debit extends BaseEntity {
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
}
