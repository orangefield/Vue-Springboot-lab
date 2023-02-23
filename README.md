# Vue랑 Springboot 연결하는 중인데

### 공부해야할 것
```
1. vue에서 주소를 어떻게 설정하는가
```

### Oracle Sequence
1. 오라클 시퀀스 생성
```
CREATE SEQUENCE 시퀀스이름
START WITH 1 INCREMENT BY 1;

DROP SEQUENCE 시퀀스이름;
```
2. 시퀀스 매핑
```
@SequenceGenerator(~)
@GeneratedValue(~)
```