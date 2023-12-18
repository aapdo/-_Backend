# donggukthon_2023_5_B

## ✏️ Commit Type

Type |	설명
--------|--------
Feat | 새로운 기능 추가
Fix |	버그 수정 또는 typo
Refactor | 리팩토링
Design | CSS 등 사용자 UI 디자인 변경
Comment | 필요한 주석 추가 및 변경
Style | 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
Test | 테스트(테스트 코드 추가, 수정, 삭제, 비즈니스 로직에 변경이 없는 경우)
Chore | 위에 걸리지 않는 기타 변경사항(빌드 스크립트 수정, assets image, 패키지 매니저 등)
Init | 프로젝트 초기 생성
Rename | 파일 혹은 폴더명 수정하거나 옮기는 경우
Remove | 파일을 삭제하는 작업만 수행하는 경우

## 🐭 Subject RulePermalink

1. 제목은 최대 50글자 넘지 않기
2. 마침표 및 특수기호 사용x
3. 첫 글자 대문자, 명령문 사용
4. 개조식 구문으로 작성(간결하고 요점적인 서술)

## 🐭 Body RulePermalink

1. 한 줄당 72자 내로 작성
2. 최대한 상세히 작성
3. 어떻게 보다는 '무엇을', '왜' 변경했는지에 대해 작성

## 🐮 Footer RulePermalink

1. 유형: #이슈 번호의 형식으로 작성
2. 이슈 트래커 ID를 작성
3. 여러개의 이슈 번호는 ,로 구분
4. 이슈 트래커 유형은 아래와 같다.

Issue Tracker	| 설명
--------------|------
Fixes |	이슈 수정중(아직 해결되지 않은 경우)
Resolves |	이슈를 해결한 경우
Ref |	참조할 이슈가 있을 때 사용
Related to |	해당 커밋에 관련된 이슈 번호(아직 해결되지 않은 경우)

ex) Footer에 Fixes  #1 이라고 작성하고 commit을 할 경우, 자동으로 issue #1과 매칭이 된다.

