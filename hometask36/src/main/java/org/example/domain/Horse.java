package org.example.domain;

import lombok.*;

import java.util.List;


@RequiredArgsConstructor
public  class Horse {

   @Getter
   public static final List<Integer> horses = List.of(1,2,3,4,5);

}


