# MP2 Feedback

## Grade: B

**Compiles**: Yes:Yes:Yes:Yes:Yes:Yes

**Timeout**: No:No:No:No:No:No

## Test Results
### mp2.grading.Task1
| Test Status | Count |
| ----------- | ----- |
|tests|10|
|skipped|0|
|failures|0|
|errors|0|

### mp2.grading.Task1B
| Test Status | Count |
| ----------- | ----- |
|tests|10|
|skipped|0|
|failures|0|
|errors|0|

### mp2.grading.Task2
| Test Status | Count |
| ----------- | ----- |
|tests|12|
|skipped|0|
|failures|0|
|errors|0|

### mp2.grading.Task3
| Test Status | Count |
| ----------- | ----- |
|tests|12|
|skipped|0|
|failures|1|
|errors|0|
#### Failed Tests
1. `[2] cpen221.mp2.graph.Graph@314, cpen221.mp2.graph.Vertex@42, cpen221.mp2.graph.Vertex@48, 0 (org.opentest4j.AssertionFailedError)`

### mp2.grading.Task4A
| Test Status | Count |
| ----------- | ----- |
|tests|8|
|skipped|0|
|failures|0|
|errors|0|

### mp2.grading.Task4B
| Test Status | Count |
| ----------- | ----- |
|tests|4|
|skipped|0|
|failures|0|
|errors|0|

## Code Coverage
### Graph
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|33|
|LINE_COVERED|306|
|BRANCH_MISSED|25|
|BRANCH_COVERED|183|
### Edge
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|31|
|LINE_COVERED|21|
|BRANCH_MISSED|33|
|BRANCH_COVERED|13|
### ALGraph
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|0|
|LINE_COVERED|79|
|BRANCH_MISSED|5|
|BRANCH_COVERED|71|
### AMGraph
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|0|
|LINE_COVERED|78|
|BRANCH_MISSED|5|
|BRANCH_COVERED|61|

## Comments
**Need to improve with thinking through core concepts such as representation invariants and abstraction functions.**
### General
- Does not have proper RI or AF for the most part, please review
- Some variable names are vague, the rule of thumb is a reader should be able to tell what a variable is without a comment
- Some of the specs are missing a description of when each return value occurs
- Very few comments

### AMGraph (Task 1 and 2)
- Does not have proper RI or AF
- No comments, there should be at least one comment per major block of code
- Good variable names
- Good coding style
- In constructor specification missing parameter
- In specs where the method returns true or false based on success, does not describe the failure conditions, for example for add edge, when does it fail
- Otherwise good specifications

### ALGraph (Task 1 and 2)
- Better RI
- AF does not describe the mapping between the abstraction (the graph) and the representatioon (your code)
- No comments, there should be at least one comment per major block of code
- Some vague variable names such as "l", but otherwise good
- Good coding style
- Good specifications, for the add edge method mentions the failure conditions

### Graph (Task 3 and 4)
- Does not have proper AF
- RI needs more conditions, such as all the Hash Set of edges inside al must not be NULL, this is important, since it is assumed inside some of the functions such as Shortest Path
- The methods that are comments are good, but many methods are missing comments
- Vague variable names such as "m" in get all paths
- Some long methods that could be broken up
- In some specs where the method returns true or false based on success, does not describe the failure conditions, for example for add vertex, when does it fail
- Specs were mostly good

### Kamino Game (Task 5)
- Good comments
- Good variable names
- Good coding style


**Detailed Code Analysis**

| Filename | Line | Issue | Explanation |
| -------- | ---- | ----- | ----------- |
|ALGraph.java|4|	TooManyMethods|	This class has too many methods, consider refactoring it.|
|ALGraph.java|11|	BeanMembersShouldSerialize|	Found non-transient, non-static member. Please mark as transient or provide accessors.|
|ALGraph.java|12|	BeanMembersShouldSerialize|	Found non-transient, non-static member. Please mark as transient or provide accessors.|
|ALGraph.java|13|	BeanMembersShouldSerialize|	Found non-transient, non-static member. Please mark as transient or provide accessors.|
|ALGraph.java|43|	SimplifyBooleanReturns|	Avoid unnecessary if..then..else statements when returning booleans|
|ALGraph.java|58|	CognitiveComplexity|	The method 'addEdge(E)' has a cognitive complexity of 15, current threshold is 15|
|ALGraph.java|60|	CollapsibleIfStatements|	These nested if statements could be combined|
|ALGraph.java|63|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
|ALGraph.java|66|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
|ALGraph.java|84|	SimplifyBooleanReturns|	Avoid unnecessary if..then..else statements when returning booleans|
|ALGraph.java|237|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
|ALGraph.java|237|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
|ALGraph.java|238|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
|ALGraph.java|241|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
## Checkstyle Results
### `Controller.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `GathererStage.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `HunterStage.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `Kamino.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 49 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 50 | 13 | `Catching 'Exception' is not allowed.` |
| 109 | 47 | `'7' is a magic number.` |
| 110 | 49 | `'7' is a magic number.` |
| 111 | 61 | `'7' is a magic number.` |
| 114 | 25 | `Control variable 'i' is modified.` |
| 124 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 145 | 30 | `'seed' hides a field.` |
| 157 | 17 | `'.' should be on the previous line.` |
| 164 | 32 | `'seed' hides a field.` |
| 170 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 177 | 30 | `'seed' hides a field.` |
| 210 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 276 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 279 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 280 | 38 | `Empty catch block.` |
### `Spaceship.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
### `ALGraph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 23 | 9 | `'if' is not followed by whitespace.` |
| 23 | 22 | `'{' is not preceded with whitespace.` |
| 25 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 43 | 9 | `'if' is not followed by whitespace.` |
| 43 | 9 | `Conditional logic can be removed.` |
| 43 | 29 | `'{' is not preceded with whitespace.` |
| 45 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 46 | 9 | `'else' is not followed by whitespace.` |
| 46 | 13 | `'{' is not preceded with whitespace.` |
| 59 | 9 | `'if' is not followed by whitespace.` |
| 59 | 21 | `'{' is not preceded with whitespace.` |
| 60 | 13 | `'if' is not followed by whitespace.` |
| 84 | 9 | `'if' is not followed by whitespace.` |
| 84 | 9 | `Conditional logic can be removed.` |
| 84 | 29 | `'{' is not preceded with whitespace.` |
| 86 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 101 | 9 | `'for' is not followed by whitespace.` |
| 101 | 23 | `'{' is not preceded with whitespace.` |
| 102 | 13 | `'if' is not followed by whitespace.` |
| 102 | 23 | `'==' is not followed by whitespace.` |
| 102 | 23 | `'==' is not preceded with whitespace.` |
| 102 | 37 | `'==' is not followed by whitespace.` |
| 102 | 37 | `'==' is not preceded with whitespace.` |
| 102 | 52 | `'==' is not followed by whitespace.` |
| 102 | 52 | `'==' is not preceded with whitespace.` |
| 102 | 66 | `'==' is not followed by whitespace.` |
| 102 | 66 | `'==' is not preceded with whitespace.` |
| 102 | 71 | `'{' is not preceded with whitespace.` |
| 118 | 9 | `'if' is not followed by whitespace.` |
| 118 | 19 | `',' is not followed by whitespace.` |
| 118 | 24 | `'{' is not preceded with whitespace.` |
| 119 | 13 | `'for' is not followed by whitespace.` |
| 119 | 27 | `'{' is not preceded with whitespace.` |
| 120 | 17 | `'if' is not followed by whitespace.` |
| 120 | 27 | `'==' is not followed by whitespace.` |
| 120 | 27 | `'==' is not preceded with whitespace.` |
| 120 | 41 | `'==' is not followed by whitespace.` |
| 120 | 41 | `'==' is not preceded with whitespace.` |
| 120 | 56 | `'==' is not followed by whitespace.` |
| 120 | 56 | `'==' is not preceded with whitespace.` |
| 120 | 70 | `'==' is not followed by whitespace.` |
| 120 | 70 | `'==' is not preceded with whitespace.` |
| 120 | 75 | `'{' is not preceded with whitespace.` |
| 124 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 125 | 14 | `'if' is not followed by whitespace.` |
| 125 | 31 | `'{' is not preceded with whitespace.` |
| 139 | 9 | `'for' is not followed by whitespace.` |
| 139 | 23 | `'{' is not preceded with whitespace.` |
| 155 | 13 | `'for' is not followed by whitespace.` |
| 155 | 36 | `'{' is not preceded with whitespace.` |
| 156 | 17 | `'if' is not followed by whitespace.` |
| 156 | 28 | `'==' is not followed by whitespace.` |
| 156 | 28 | `'==' is not preceded with whitespace.` |
| 156 | 37 | `'{' is not preceded with whitespace.` |
| 159 | 17 | `'if' is not followed by whitespace.` |
| 159 | 28 | `'==' is not followed by whitespace.` |
| 159 | 28 | `'==' is not preceded with whitespace.` |
| 159 | 37 | `'{' is not preceded with whitespace.` |
| 164 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 179 | 9 | `'if' is not followed by whitespace.` |
| 179 | 22 | `'{' is not preceded with whitespace.` |
| 184 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 209 | 9 | `'for' is not followed by whitespace.` |
| 209 | 23 | `'{' is not preceded with whitespace.` |
| 210 | 13 | `'if' is not followed by whitespace.` |
| 210 | 22 | `'==' is not followed by whitespace.` |
| 210 | 22 | `'==' is not preceded with whitespace.` |
| 210 | 35 | `'==' is not followed by whitespace.` |
| 210 | 35 | `'==' is not preceded with whitespace.` |
| 210 | 39 | `'{' is not preceded with whitespace.` |
| 235 | 40 | `';' is not followed by whitespace.` |
| 235 | 41 | `'{' is not preceded with whitespace.` |
| 236 | 13 | `'for' is not followed by whitespace.` |
| 236 | 27 | `'{' is not preceded with whitespace.` |
| 237 | 17 | `'if' is not followed by whitespace.` |
| 237 | 57 | `'{' is not preceded with whitespace.` |
| 238 | 21 | `'if' is not followed by whitespace.` |
| 238 | 41 | `'{' is not preceded with whitespace.` |
| 241 | 21 | `'if' is not followed by whitespace.` |
| 241 | 41 | `'{' is not preceded with whitespace.` |
### `AMGraph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 34 | 11 | `Found a TODO or FIXME comment` |
| 39 | 19 | `'=' is not followed by whitespace.` |
| 39 | 19 | `'=' is not preceded with whitespace.` |
| 39 | 24 | `'<' is not followed by whitespace.` |
| 39 | 24 | `'<' is not preceded with whitespace.` |
| 40 | 23 | `'=' is not followed by whitespace.` |
| 40 | 23 | `'=' is not preceded with whitespace.` |
| 40 | 28 | `'<' is not followed by whitespace.` |
| 40 | 28 | `'<' is not preceded with whitespace.` |
| 41 | 22 | `'==' is not followed by whitespace.` |
| 41 | 22 | `'==' is not preceded with whitespace.` |
| 42 | 34 | `'=' is not followed by whitespace.` |
| 42 | 34 | `'=' is not preceded with whitespace.` |
| 43 | 17 | `'}' at column 17 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 45 | 34 | `'=' is not followed by whitespace.` |
| 45 | 34 | `'=' is not preceded with whitespace.` |
| 59 | 28 | `'+' is not followed by whitespace.` |
| 59 | 28 | `'+' is not preceded with whitespace.` |
| 59 | 30 | `'>' is not followed by whitespace.` |
| 59 | 30 | `'>' is not preceded with whitespace.` |
| 59 | 42 | `'||' is not preceded with whitespace.` |
| 90 | 39 | `'||' is not followed by whitespace.` |
| 90 | 39 | `'||' is not preceded with whitespace.` |
| 94 | 68 | `'=' is not followed by whitespace.` |
| 94 | 68 | `'=' is not preceded with whitespace.` |
| 95 | 68 | `'=' is not followed by whitespace.` |
| 95 | 68 | `'=' is not preceded with whitespace.` |
| 120 | 34 | `'&&' is not followed by whitespace.` |
| 120 | 34 | `'&&' is not preceded with whitespace.` |
| 123 | 34 | `'&&' is not followed by whitespace.` |
| 123 | 34 | `'&&' is not preceded with whitespace.` |
| 142 | 34 | `'&&' is not followed by whitespace.` |
| 142 | 34 | `'&&' is not preceded with whitespace.` |
| 145 | 34 | `'&&' is not followed by whitespace.` |
| 145 | 34 | `'&&' is not preceded with whitespace.` |
| 177 | 39 | `'||' is not followed by whitespace.` |
| 177 | 39 | `'||' is not preceded with whitespace.` |
| 201 | 19 | `'=' is not followed by whitespace.` |
| 201 | 19 | `'=' is not preceded with whitespace.` |
| 201 | 24 | `'<' is not followed by whitespace.` |
| 201 | 24 | `'<' is not preceded with whitespace.` |
| 232 | 33 | `'||' is not followed by whitespace.` |
| 232 | 33 | `'||' is not preceded with whitespace.` |
| 259 | 14 | `',' is not followed by whitespace.` |
| 262 | 38 | `',' is not followed by whitespace.` |
| 265 | 38 | `',' is not followed by whitespace.` |
### `Edge.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 109 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
### `Graph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 15 | 31 | `Class member (field) 'al' may not be public.` |
| 15 | 33 | `'=' is not preceded with whitespace.` |
| 27 | 19 | `'=' is not followed by whitespace.` |
| 27 | 19 | `'=' is not preceded with whitespace.` |
| 29 | 16 | `Local variable 'e_set' must be in camelCase, or consist of a single upper-case letter.` |
| 29 | 22 | `'=' is not followed by whitespace.` |
| 30 | 9 | `'if' is not followed by whitespace.` |
| 30 | 19 | `',' is not followed by whitespace.` |
| 36 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 37 | 9 | `'else' is not followed by whitespace.` |
| 37 | 13 | `'{' is not preceded with whitespace.` |
| 40 | 17 | `Local variable 'e_obj' must be in camelCase, or consist of a single upper-case letter.` |
| 40 | 22 | `'=' is not followed by whitespace.` |
| 40 | 22 | `'=' is not preceded with whitespace.` |
| 40 | 36 | `',' is not followed by whitespace.` |
| 40 | 39 | `',' is not followed by whitespace.` |
| 50 | 25 | `Method name 'get_neighbour_vertex' must be in camelCase, or consist of a single upper-case letter.` |
| 50 | 50 | `'{' is not preceded with whitespace.` |
| 51 | 14 | `',' is not followed by whitespace.` |
| 51 | 27 | `'=' is not followed by whitespace.` |
| 51 | 27 | `'=' is not preceded with whitespace.` |
| 52 | 16 | `Local variable 'neighbour_v_set' must be in camelCase, or consist of a single upper-case letter.` |
| 52 | 31 | `'=' is not followed by whitespace.` |
| 52 | 31 | `'=' is not preceded with whitespace.` |
| 62 | 36 | `Method name 'GetAllPath' must be in camelCase, or consist of a single upper-case letter.` |
| 62 | 62 | `'{' is not preceded with whitespace.` |
| 63 | 30 | `Local variable 'neighbour_map' must be in camelCase, or consist of a single upper-case letter.` |
| 63 | 43 | `'=' is not followed by whitespace.` |
| 63 | 43 | `'=' is not preceded with whitespace.` |
| 64 | 16 | `Local variable 'all_vertex' must be in camelCase, or consist of a single upper-case letter.` |
| 64 | 26 | `'=' is not followed by whitespace.` |
| 64 | 26 | `'=' is not preceded with whitespace.` |
| 65 | 33 | `Local variable 'AllPath' must be in camelCase, or consist of a single upper-case letter.` |
| 65 | 40 | `'=' is not followed by whitespace.` |
| 65 | 40 | `'=' is not preceded with whitespace.` |
| 66 | 9 | `'for' is not followed by whitespace.` |
| 66 | 28 | `'{' is not preceded with whitespace.` |
| 67 | 27 | `'=' is not followed by whitespace.` |
| 67 | 27 | `'=' is not preceded with whitespace.` |
| 68 | 32 | `',' is not followed by whitespace.` |
| 70 | 34 | `'=' is not followed by whitespace.` |
| 70 | 34 | `'=' is not preceded with whitespace.` |
| 71 | 25 | `'=' is not preceded with whitespace.` |
| 74 | 9 | `'while' is not followed by whitespace.` |
| 74 | 32 | `'{' is not preceded with whitespace.` |
| 76 | 17 | `'=' is not followed by whitespace.` |
| 76 | 17 | `'=' is not preceded with whitespace.` |
| 77 | 13 | `'if' is not followed by whitespace.` |
| 77 | 36 | `'-' is not followed by whitespace.` |
| 77 | 36 | `'-' is not preceded with whitespace.` |
| 77 | 52 | `'{' is not preceded with whitespace.` |
| 81 | 22 | `'=' is not followed by whitespace.` |
| 81 | 43 | `'-' is not followed by whitespace.` |
| 81 | 43 | `'-' is not preceded with whitespace.` |
| 82 | 27 | `'=' is not followed by whitespace.` |
| 82 | 27 | `'=' is not preceded with whitespace.` |
| 85 | 34 | `Local variable 'new_path' must be in camelCase, or consist of a single upper-case letter.` |
| 102 | 33 | `Local variable 'AllPath' must be in camelCase, or consist of a single upper-case letter.` |
| 102 | 40 | `'=' is not followed by whitespace.` |
| 102 | 40 | `'=' is not preceded with whitespace.` |
| 102 | 74 | `',' is not followed by whitespace.` |
| 103 | 17 | `Local variable 'shortest_path' must be in camelCase, or consist of a single upper-case letter.` |
| 103 | 30 | `'=' is not followed by whitespace.` |
| 103 | 30 | `'=' is not preceded with whitespace.` |
| 104 | 13 | `Local variable 'min_length' must be in camelCase, or consist of a single upper-case letter.` |
| 104 | 23 | `'=' is not followed by whitespace.` |
| 104 | 23 | `'=' is not preceded with whitespace.` |
| 105 | 9 | `'for' is not followed by whitespace.` |
| 105 | 26 | `'al' hides a field.` |
| 105 | 38 | `'{' is not preceded with whitespace.` |
| 106 | 23 | `'=' is not followed by whitespace.` |
| 106 | 23 | `'=' is not preceded with whitespace.` |
| 107 | 13 | `'for' is not followed by whitespace.` |
| 107 | 22 | `'=' is not followed by whitespace.` |
| 107 | 22 | `'=' is not preceded with whitespace.` |
| 107 | 24 | `';' is not followed by whitespace.` |
| 107 | 26 | `'<' is not followed by whitespace.` |
| 107 | 26 | `'<' is not preceded with whitespace.` |
| 107 | 36 | `'-' is not followed by whitespace.` |
| 107 | 36 | `'-' is not preceded with whitespace.` |
| 107 | 38 | `';' is not followed by whitespace.` |
| 107 | 43 | `'{' is not preceded with whitespace.` |
| 108 | 23 | `'+=' is not preceded with whitespace.` |
| 108 | 46 | `',' is not followed by whitespace.` |
| 108 | 55 | `'+' is not followed by whitespace.` |
| 108 | 55 | `'+' is not preceded with whitespace.` |
| 110 | 13 | `'if' is not followed by whitespace.` |
| 110 | 22 | `'<' is not followed by whitespace.` |
| 110 | 22 | `'<' is not preceded with whitespace.` |
| 110 | 34 | `'{' is not preceded with whitespace.` |
| 111 | 27 | `'=' is not followed by whitespace.` |
| 111 | 27 | `'=' is not preceded with whitespace.` |
| 112 | 30 | `'=' is not followed by whitespace.` |
| 112 | 30 | `'=' is not preceded with whitespace.` |
| 115 | 9 | `'if' is not followed by whitespace.` |
| 115 | 32 | `'>' is not followed by whitespace.` |
| 115 | 32 | `'>' is not preceded with whitespace.` |
| 115 | 35 | `'{' is not preceded with whitespace.` |
| 129 | 19 | `'=' is not followed by whitespace.` |
| 129 | 19 | `'=' is not preceded with whitespace.` |
| 130 | 9 | `'for' is not followed by whitespace.` |
| 130 | 18 | `'=' is not followed by whitespace.` |
| 130 | 18 | `'=' is not preceded with whitespace.` |
| 130 | 23 | `'<' is not followed by whitespace.` |
| 130 | 23 | `'<' is not preceded with whitespace.` |
| 130 | 35 | `'-' is not followed by whitespace.` |
| 130 | 35 | `'-' is not preceded with whitespace.` |
| 130 | 37 | `';' is not followed by whitespace.` |
| 130 | 42 | `')' is preceded with whitespace.` |
| 130 | 43 | `'{' is not preceded with whitespace.` |
| 131 | 19 | `'+=' is not preceded with whitespace.` |
| 131 | 44 | `',' is not followed by whitespace.` |
| 131 | 55 | `'+' is not followed by whitespace.` |
| 131 | 55 | `'+' is not preceded with whitespace.` |
| 146 | 14 | `',' is not followed by whitespace.` |
| 146 | 21 | `'=' is not followed by whitespace.` |
| 146 | 21 | `'=' is not preceded with whitespace.` |
| 147 | 16 | `Local variable 'all_v' must be in camelCase, or consist of a single upper-case letter.` |
| 147 | 21 | `'=' is not preceded with whitespace.` |
| 149 | 9 | `'for' is not followed by whitespace.` |
| 149 | 23 | `'{' is not preceded with whitespace.` |
| 150 | 25 | `'=' is not followed by whitespace.` |
| 150 | 25 | `'=' is not preceded with whitespace.` |
| 150 | 56 | `',' is not followed by whitespace.` |
| 151 | 17 | `Local variable 'shortest_length' must be in camelCase, or consist of a single upper-case letter.` |
| 151 | 32 | `'=' is not followed by whitespace.` |
| 151 | 32 | `'=' is not preceded with whitespace.` |
| 152 | 13 | `'if' is not followed by whitespace.` |
| 152 | 31 | `'<=' is not followed by whitespace.` |
| 152 | 31 | `'<=' is not preceded with whitespace.` |
| 152 | 39 | `'{' is not preceded with whitespace.` |
| 153 | 26 | `',' is not followed by whitespace.` |
| 153 | 55 | `'-' is not followed by whitespace.` |
| 153 | 55 | `'-' is not preceded with whitespace.` |
| 153 | 58 | `',' is not followed by whitespace.` |
| 280 | 9 | `'for' is not followed by whitespace.` |
| 280 | 23 | `'{' is not preceded with whitespace.` |
| 316 | 9 | `'for' is not followed by whitespace.` |
| 316 | 39 | `'{' is not preceded with whitespace.` |
| 317 | 13 | `'if' is not followed by whitespace.` |
| 317 | 38 | `'>' is not followed by whitespace.` |
| 317 | 38 | `'>' is not preceded with whitespace.` |
| 317 | 77 | `'{' is not preceded with whitespace.` |
| 319 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 320 | 18 | `'if' is not followed by whitespace.` |
| 320 | 43 | `'==' is not followed by whitespace.` |
| 320 | 43 | `'==' is not preceded with whitespace.` |
| 320 | 83 | `'{' is not preceded with whitespace.` |
| 321 | 17 | `'if' is not followed by whitespace.` |
| 321 | 37 | `'>' is not followed by whitespace.` |
| 321 | 37 | `'>' is not preceded with whitespace.` |
| 321 | 71 | `'{' is not preceded with whitespace.` |
| 364 | 9 | `'for' is not followed by whitespace.` |
| 364 | 23 | `'{' is not preceded with whitespace.` |
| 400 | 9 | `'for' is not followed by whitespace.` |
| 400 | 39 | `'{' is not preceded with whitespace.` |
| 401 | 13 | `'if' is not followed by whitespace.` |
| 401 | 38 | `'>' is not followed by whitespace.` |
| 401 | 38 | `'>' is not preceded with whitespace.` |
| 401 | 77 | `'{' is not preceded with whitespace.` |
| 403 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 404 | 18 | `'if' is not followed by whitespace.` |
| 404 | 43 | `'==' is not followed by whitespace.` |
| 404 | 43 | `'==' is not preceded with whitespace.` |
| 404 | 83 | `'{' is not preceded with whitespace.` |
| 405 | 17 | `'if' is not followed by whitespace.` |
| 405 | 37 | `'>' is not followed by whitespace.` |
| 405 | 37 | `'>' is not preceded with whitespace.` |
| 405 | 71 | `'{' is not preceded with whitespace.` |
| 437 | 9 | `'if' is not followed by whitespace.` |
| 437 | 30 | `'{' is not preceded with whitespace.` |
| 461 | 9 | `'if' is not followed by whitespace.` |
| 461 | 35 | `'||' is not followed by whitespace.` |
| 461 | 35 | `'||' is not preceded with whitespace.` |
| 464 | 13 | `'if' has incorrect indentation level 12, expected level should be 8.` |
| 464 | 13 | `'if' is not followed by whitespace.` |
| 464 | 25 | `'{' is not preceded with whitespace.` |
| 465 | 17 | `'if' has incorrect indentation level 16, expected level should be 12.` |
| 465 | 17 | `'if' is not followed by whitespace.` |
| 465 | 34 | `'&&' is not followed by whitespace.` |
| 465 | 34 | `'&&' is not preceded with whitespace.` |
| 465 | 51 | `'{' is not preceded with whitespace.` |
| 466 | 21 | `'if' child has incorrect indentation level 20, expected level should be 16.` |
| 467 | 21 | `'if' child has incorrect indentation level 20, expected level should be 16.` |
| 468 | 17 | `'if rcurly' has incorrect indentation level 16, expected level should be 12.` |
| 469 | 17 | `'if' child has incorrect indentation level 16, expected level should be 12.` |
| 470 | 13 | `'if rcurly' has incorrect indentation level 12, expected level should be 8.` |
| 471 | 13 | `'method def' child has incorrect indentation level 12, expected level should be 8.` |
| 481 | 16 | `Local variable 'edge_set' must be in camelCase, or consist of a single upper-case letter.` |
| 481 | 24 | `'=' is not followed by whitespace.` |
| 481 | 24 | `'=' is not preceded with whitespace.` |
| 494 | 20 | `Local variable 'v_list' must be in camelCase, or consist of a single upper-case letter.` |
| 494 | 26 | `'=' is not followed by whitespace.` |
| 494 | 26 | `'=' is not preceded with whitespace.` |
| 495 | 9 | `'for' is not followed by whitespace.` |
| 495 | 24 | `'{' is not preceded with whitespace.` |
| 496 | 13 | `'if' is not followed by whitespace.` |
| 496 | 22 | `'==' is not followed by whitespace.` |
| 496 | 22 | `'==' is not preceded with whitespace.` |
| 496 | 27 | `'{' is not preceded with whitespace.` |
| 497 | 17 | `'if' is not followed by whitespace.` |
| 497 | 26 | `'==' is not followed by whitespace.` |
| 497 | 26 | `'==' is not preceded with whitespace.` |
| 497 | 31 | `'{' is not preceded with whitespace.` |
| 501 | 13 | `'if' is not followed by whitespace.` |
| 501 | 22 | `'==' is not followed by whitespace.` |
| 501 | 22 | `'==' is not preceded with whitespace.` |
| 501 | 27 | `'{' is not preceded with whitespace.` |
| 502 | 17 | `'if' is not followed by whitespace.` |
| 502 | 26 | `'==' is not followed by whitespace.` |
| 502 | 26 | `'==' is not preceded with whitespace.` |
| 502 | 31 | `'{' is not preceded with whitespace.` |
| 519 | 20 | `Local variable 'e_list' must be in camelCase, or consist of a single upper-case letter.` |
| 519 | 26 | `'=' is not followed by whitespace.` |
| 519 | 26 | `'=' is not preceded with whitespace.` |
| 520 | 9 | `'if' is not followed by whitespace.` |
| 520 | 26 | `'{' is not preceded with whitespace.` |
| 522 | 9 | `'}' is not followed by whitespace.` |
| 522 | 10 | `'else' is not preceded with whitespace.` |
| 525 | 33 | `'.' is preceded with whitespace.` |
| 540 | 16 | `'=' is not followed by whitespace.` |
| 540 | 16 | `'=' is not preceded with whitespace.` |
| 541 | 19 | `'=' is not followed by whitespace.` |
| 541 | 19 | `'=' is not preceded with whitespace.` |
| 542 | 9 | `'for' is not followed by whitespace.` |
| 542 | 31 | `'{' is not preceded with whitespace.` |
| 543 | 24 | `Local variable 'e_list' must be in camelCase, or consist of a single upper-case letter.` |
| 543 | 30 | `'=' is not followed by whitespace.` |
| 543 | 30 | `'=' is not preceded with whitespace.` |
| 546 | 9 | `'for' is not followed by whitespace.` |
| 546 | 21 | `'{' is not preceded with whitespace.` |
| 547 | 16 | `'+=' is not followed by whitespace.` |
| 547 | 16 | `'+=' is not preceded with whitespace.` |
| 559 | 9 | `'if' is not followed by whitespace.` |
| 559 | 20 | `'{' is not preceded with whitespace.` |
| 560 | 26 | `',' is not followed by whitespace.` |
| 560 | 45 | `'->' is not followed by whitespace.` |
| 560 | 45 | `'->' is not preceded with whitespace.` |
| 574 | 9 | `'if' is not followed by whitespace.` |
| 574 | 22 | `'{' is not preceded with whitespace.` |
| 576 | 23 | `'=' is not followed by whitespace.` |
| 576 | 23 | `'=' is not preceded with whitespace.` |
| 577 | 13 | `'for' is not followed by whitespace.` |
| 577 | 26 | `'{' is not preceded with whitespace.` |
| 578 | 28 | `Local variable 'e_set' must be in camelCase, or consist of a single upper-case letter.` |
| 578 | 33 | `'=' is not followed by whitespace.` |
| 578 | 33 | `'=' is not preceded with whitespace.` |
| 615 | 16 | `Local variable 'e_set' must be in camelCase, or consist of a single upper-case letter.` |
| 615 | 21 | `'=' is not followed by whitespace.` |
| 615 | 21 | `'=' is not preceded with whitespace.` |
| 616 | 16 | `Local variable 'v_set' must be in camelCase, or consist of a single upper-case letter.` |
| 616 | 21 | `'=' is not followed by whitespace.` |
| 616 | 21 | `'=' is not preceded with whitespace.` |
| 617 | 9 | `'for' is not followed by whitespace.` |
| 617 | 23 | `'{' is not preceded with whitespace.` |
| 631 | 14 | `',' is not followed by whitespace.` |
| 631 | 27 | `'=' is not followed by whitespace.` |
| 631 | 27 | `'=' is not preceded with whitespace.` |
| 632 | 16 | `Local variable 'edge_set' must be in camelCase, or consist of a single upper-case letter.` |
| 632 | 24 | `'=' is not followed by whitespace.` |
| 632 | 24 | `'=' is not preceded with whitespace.` |
| 633 | 9 | `'for' is not followed by whitespace.` |
| 633 | 26 | `'{' is not preceded with whitespace.` |
| 634 | 13 | `'if' is not followed by whitespace.` |
| 634 | 22 | `'==' is not followed by whitespace.` |
| 634 | 22 | `'==' is not preceded with whitespace.` |
| 634 | 26 | `'{' is not preceded with whitespace.` |
| 635 | 37 | `',' is not followed by whitespace.` |
| 636 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 637 | 18 | `'if' is not followed by whitespace.` |
| 637 | 27 | `'==' is not followed by whitespace.` |
| 637 | 27 | `'==' is not preceded with whitespace.` |
| 637 | 31 | `'{' is not preceded with whitespace.` |
| 638 | 37 | `',' is not followed by whitespace.` |
| 644 | 1 | `Block comment has incorrect indentation level 0, expected is 4, indentation should be the same level as line 657.` |
| 709 | 4 | `'method def modifier' has incorrect indentation level 3, expected level should be 4.` |
| 719 | 8 | `'method def' child has incorrect indentation level 7, expected level should be 8.` |
| 720 | 4 | `'method def rcurly' has incorrect indentation level 3, expected level should be 4.` |
### `ImGraph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `MGraph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `Vertex.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 61 | 35 | `'name' hides a field.` |
### `Circle.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `Drawable.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `GUI.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 47 | 50 | `'0.8' is a magic number.` |
| 118 | 17 | `'.' should be on the previous line.` |
| 137 | 5 | `';' is preceded with whitespace.` |
| 200 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 205 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 206 | 13 | `Catching 'Exception' is not allowed.` |
| 206 | 33 | `Empty catch block.` |
| 233 | 9 | `switch without "default" clause.` |
| 337 | 64 | `'1e6' is a magic number.` |
| 338 | 61 | `'1e6' is a magic number.` |
### `Line.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 16 | 13 | `'array initialization' child has incorrect indentation level 12, expected level should be one of the following: 8, 42, 45.` |
| 48 | 56 | `'3' is a magic number.` |
### `Planet.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 53 | 36 | `'256' is a magic number.` |
| 53 | 52 | `'256' is a magic number.` |
| 53 | 68 | `'256' is a magic number.` |
### `Ship.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `SidePanel.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 54 | 5 | `Method SidePanel length is 81 lines (max allowed is 80).` |
| 57 | 35 | `'10' is a magic number.` |
| 57 | 39 | `'10' is a magic number.` |
| 57 | 43 | `'10' is a magic number.` |
| 57 | 47 | `'10' is a magic number.` |
| 110 | 48 | `'3' is a magic number.` |
| 110 | 51 | `'5' is a magic number.` |
| 110 | 54 | `'3' is a magic number.` |
| 110 | 57 | `'5' is a magic number.` |
| 206 | 13 | `'0.299d' is a magic number.` |
| 206 | 35 | `'0.587d' is a magic number.` |
| 206 | 59 | `'0.114d' is a magic number.` |
| 206 | 82 | `'127d' is a magic number.` |
| 229 | 44 | `'10' is a magic number.` |
| 230 | 44 | `'5' is a magic number.` |
| 317 | 23 | `'static' modifier out of order with the JLS suggestions.` |
### `SpacePanel.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 58 | 13 | `switch without "default" clause.` |
| 84 | 13 | `switch without "default" clause.` |
| 151 | 54 | `'3' is a magic number.` |
| 166 | 21 | `'.' should be on the previous line.` |
| 167 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 201 | 60 | `'0.02' is a magic number.` |
| 266 | 13 | `switch without "default" clause.` |
| 310 | 5 | `';' is preceded with whitespace.` |
### `TopMenu.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `DelaunayTriangulation.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 46 | 1 | `File contains tab characters (this is the first instance).` |
| 97 | 13 | `Local variable 'OUTER_BOUND' must be in camelCase, or consist of a single upper-case letter.` |
| 99 | 51 | `'3' is a magic number.` |
| 100 | 30 | `'3' is a magic number.` |
### `HistoryEvent.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 24 | 1 | `File contains tab characters (this is the first instance).` |
| 24 | 26 | `'3' is a magic number.` |
### `PointLocation.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `Triangle.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 20 | 36 | `'3' is a magic number.` |
| 24 | 46 | `'3' is a magic number.` |
| 110 | 39 | `'3' is a magic number.` |
| 111 | 30 | `'3' is a magic number.` |
| 112 | 59 | `'3' is a magic number.` |
| 132 | 30 | `'3' is a magic number.` |
| 133 | 32 | `'3' is a magic number.` |
| 134 | 32 | `'3' is a magic number.` |
| 330 | 48 | `'3' is a magic number.` |
| 330 | 65 | `'3' is a magic number.` |
| 338 | 30 | `'3' is a magic number.` |
| 339 | 53 | `'3' is a magic number.` |
### `UEdge.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 48 | 1 | `File contains tab characters (this is the first instance).` |
### `Controllable.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 40 | 65 | `'{' is not followed by whitespace.` |
| 40 | 66 | `'}' is not preceded with whitespace.` |
### `GameElement.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `GameModel.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 141 | 54 | `'1e3' is a magic number.` |
| 232 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 233 | 44 | `Empty catch block.` |
| 412 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 413 | 44 | `Empty catch block.` |
### `Link.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `Model.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 105 | 5 | `';' is preceded with whitespace.` |
### `Planet.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 110 | 38 | `'x' hides a field.` |
| 110 | 45 | `'y' hides a field.` |
| 119 | 42 | `'name' hides a field.` |
| 128 | 37 | `'id' hides a field.` |
| 137 | 40 | `'spice' hides a field.` |
### `PlanetStatus.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `ProximityGrid.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
### `Universe.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 90 | 21 | `'.' should be on the previous line.` |
| 91 | 21 | `'.' should be on the previous line.` |
| 92 | 21 | `'.' should be on the previous line.` |
| 93 | 21 | `'.' should be on the previous line.` |
| 94 | 21 | `'.' should be on the previous line.` |
| 147 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 160 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 343 | 41 | `'width' hides a field.` |
| 343 | 52 | `'height' hides a field.` |
| 352 | 42 | `'seed' hides a field.` |
### `MillenniumFalcon.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 6 | 8 | `Unused import - cpen221.mp2.graph.Graph.` |
| 11 | 8 | `Unused import - cpen221.mp2.util.Heap.` |
| 49 | 9 | `'while' is not followed by whitespace.` |
| 81 | 9 | `'while' is not followed by whitespace.` |
| 81 | 60 | `'{' is not preceded with whitespace.` |
| 86 | 17 | `'if' is not followed by whitespace.` |
| 86 | 48 | `'<' is not followed by whitespace.` |
| 86 | 48 | `'<' is not preceded with whitespace.` |
| 91 | None | `Line is longer than 120 characters (found 123).` |
| 92 | None | `Line is longer than 120 characters (found 126).` |
| 92 | 13 | `'if' is not followed by whitespace.` |
| 92 | 92 | `'<=' is not followed by whitespace.` |
| 92 | 92 | `'<=' is not preceded with whitespace.` |
| 92 | 115 | `'-' is not followed by whitespace.` |
| 92 | 115 | `'-' is not preceded with whitespace.` |
| 92 | 126 | `'{' is not preceded with whitespace.` |
| 94 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 95 | 13 | `'else' is not followed by whitespace.` |
| 95 | 17 | `'{' is not preceded with whitespace.` |
| 97 | 17 | `'for' is not followed by whitespace.` |
| 97 | 43 | `'{' is not preceded with whitespace.` |
### `Heap.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 47 | 27 | `'10' is a magic number.` |
### `Util.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `BenchmarkView.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 30 | 21 | `'1e9' is a magic number.` |
| 77 | 18 | `'i' hides a field.` |
| 89 | 18 | `'i' hides a field.` |
| 129 | 20 | `'10d' is a magic number.` |
### `CLIView.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 114 | 73 | `'+' should be on a new line.` |
### `GUIView.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `QuietView.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `View.java`
| Line | Column | Message |
| ---- | ------ | ------- |

