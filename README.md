## Stairs

Application has been created for technical test purpose during interview process.

Single stairwell has a number of flights of stairs separated by landings. 
Each flight is a straight line of steps that you can climb without stopping.  You can stride more than one step at a time when climbing each flight. 

Two strides are needed to turn on the landing and start again on next flight of stairs.

The main purpose of application is to find minimum number of strides necessary to go through the whole stairwell.

![Stairwell](https://cdn.rawgit.com/GarciaPL/Stairs/c6dd8b0f/images/stairs.png)

Application exposes inbound API called **/stairs** which consumes JSON in format specified below.

```json
{
  "input": [
    17,
    17
  ],
  "steps": 3
}
```

**Input** - number of steps in each flight of stairs
**Steps** - numbers of steps that person can cover

Response is also provided in JSON format
```json
{
  "result": 14
}
```

## Constraints
 
- Steps in range <1,4>
- Number of Inputs in range <1,30>
- Single Input in range <1,20>

## Technology

#### Stack

- Java - 1.8.0_121
- Spring Boot - 1.5.1.RELEASE

#### Libraries

- Guava - 21.0

## License
Code released under the  Apache License 2.0. Docs released under Creative Commons.

[![ghit.me](https://ghit.me/badge.svg?repo=GarciaPL/Stairs)](https://ghit.me/repo/GarciaPL/Stairs)
