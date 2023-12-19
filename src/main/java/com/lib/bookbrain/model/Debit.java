package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Debit extends BaseEntity {
/**
 *
 */
private Long debitId;
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
/**
 *
 */
private Integer createBy;
/**
 *
 */
private LocalDateTime createTime;
/**
 *
 */
private Integer updateBy;
/**
 *
 */
private LocalDateTime updateTime;
/**
 *
 */
private Integer revision;
}
