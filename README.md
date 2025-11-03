# java-lotto-8

## 기능 목록

### 정상 기능

1. 로또 구입 금액 입력 받기
   - 1,000원 단위로 입력받기
   - 구입 금액에 맞는 개수의 로또 발행
   - 잘못된 입력 시 에러 메시지 출력 후 재입력
2. 발행된 로또 번호 출력
   - 발행 개수 표시
   - 각 로또 번호 오름차순 정렬하여 출력
3. 당첨 번호 입력 받기
   - 쉼표로 구분된 6개 번호 입력
   - 잘못된 입력 시 에러 메시지 출력 후 재입력
4. 보너스 번호 입력 받기
   - 1개의 보너스 번호 입력
   - 잘못된 입력 시 에러 메시지 출력 후 재입력
5. 당첨 통계 계산 및 출력
   - 당첨 등급별 일치 개수 및 당첨금 표시
   - 총 수익률 계산 및 출력 (소수점 둘째 자리 반올림)

### 예외 처리

1. 구입 금액 검증

   - 빈 문자열 또는 null 입력
   - 1,000원으로 나누어 떨어지지 않는 경우
   - 숫자가 아닌 경우
   - 음수이거나 0인 경우
   - 잘못된 입력 시 "[ERROR]"로 시작하는 메시지 출력 후 재입력

2. 로또 번호 검증

   - 번호 개수가 6개가 아닌 경우
   - 중복된 번호가 있는 경우
   - 범위(1~45)를 벗어난 경우

3. 당첨 번호 검증

   - 빈 문자열 또는 null 입력
   - 번호 개수가 6개가 아닌 경우
   - 중복된 번호가 있는 경우
   - 범위(1~45)를 벗어난 경우
   - 숫자가 아닌 경우 (각 번호별)
   - 잘못된 입력 시 "[ERROR]"로 시작하는 메시지 출력 후 재입력

4. 보너스 번호 검증
   - 빈 문자열 또는 null 입력
   - 범위(1~45)를 벗어난 경우
   - 당첨 번호와 중복되는 경우
   - 숫자가 아닌 경우
   - 잘못된 입력 시 "[ERROR]"로 시작하는 메시지 출력 후 재입력

## 기술 스택

- Java 21
- Gradle
- JUnit 5
- AssertJ
- mission-utils (Randoms, Console API)

## 실행 방법

```bash
# 프로젝트 루트에서 실행
./gradlew run

# 테스트 실행
./gradlew test

# 특정 테스트 클래스만 실행
./gradlew test --tests ApplicationTest
```

## 프로젝트 구조

```
src/
├── main/
│   └── java/lotto/
│       ├── Application.java          # 프로그램 진입점
│       ├── Lotto.java                # 로또 클래스
│       ├── constants/                # 상수 관리 (Enum)
│       │   ├── ErrorConstants.java
│       │   ├── GameConstants.java
│       │   ├── MessageConstants.java
│       │   ├── OutputConstants.java
│       │   └── SeparatorConstants.java
│       ├── controller/               # 게임 흐름 제어
│       │   └── LottoController.java
│       ├── model/                    # 도메인 모델
│       │   ├── LottoRank.java
│       │   ├── LottoResult.java
│       │   └── WinningLotto.java
│       ├── validation/               # 입력 검증
│       │   └── InputValidator.java
│       └── view/                     # 출력 처리
│           └── LottoView.java
└── test/
    └── java/lotto/                   # 단위 테스트
        ├── ApplicationTest.java
        ├── LottoTest.java
        ├── model/
        │   ├── LottoRankTest.java
        │   ├── LottoResultTest.java
        │   └── WinningLottoTest.java
        └── validation/
            └── InputValidatorTest.java
```
