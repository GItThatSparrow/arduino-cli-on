# Introduction
The goal of this project is to expedite the delivery of quality code for the Arduino product family.
  
A lot of creative time is lost when spent configuring environments, researching hardware, downloading libraries and reviewing documentation.  As a programmer, I find a lot of value in quality code libraries - I'm referring to both commercial and community-managed libraries.  For example, when I can simply add a reference to a third-party library, `#include` it in my code, start typing and - _BOOM_ - I can see the classes and methods available.
 
 Equally important to me is the workflow among teams I work with.  I've noticed improvements in quality and turnaround time when task switching is kept to a minimum.  If we can stay in one IDE, we are more productive.  I appreciate having the option to view documentation in a small pop-up or simply `CMD + Click` into a method and review the comments directly.


I noticed the Arduino team is refactoring their code in some major ways.  If you haven't seen it, take a look over at [ The `arduino-cli` Repo](https://github.com/arduino/arduino-cli). It will be more easily leveraged from the code since they are providing the option to output as a JSON-formatted response.  making the `arduino-cli` easily accessed from the **CLion** GUI.

At the same time, I'm not an expert at C/C++ or CMake and I don't have the time it takes to master either one.  Like most projects, I learn what I need to as the need arises.  I want to incorporate modifications to the CMake files into this plugin as well.  At a high-level, when I think of the most useful features for a developer just starting out with Arduino and CLion, they are....

 1. Board browser in build configurations
 2. Code Completion
 3. Select programmer and port (if applicable)
 4. Managed 3rd party libraries (i.e. Download/import)
 5. Debugging
 6. Automated updates to CMake files
 7. Advanced configuration of `arduino-cli` commands
 8. Install/Update `arduino-cli` from CLion 

...ya, basically, all the functionality available in the Arduino IDE.

> Ultimately - with the right code completion/highlighting, file and project templates - I'm optimistic that this plugin could work in _any_ JetBrains IDE.  I'm not entirely convinced there will be anything amazing that CLion provides -- not like we need to use it's compiler or anything like that, it's all bundled with teh `arduino-cli`.

# Prerequisites

| Name  | URL | Status | Description |
|------:|:-----:|:--------:|-------------|
| Clion | [`Link`](https://www.jetbrains.com/clion/)| Production | A cross-platform IDE for C and C++ |
| Arduino CLI | [`Link`](https://github.com/arduino/arduino-cli) | Alpha | `arduino-cli` is an all-in-one solution that provides builder, boards/library manager, uploader, discovery and many other tools needed to use any Arduino compatible board and platforms. |
| IntelliJ | [`Link`](https://www.jetbrains.com/idea) | Production | |
| JetBrains Plugin SDK | [`Link`](https://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/setting_up_environment.html) | Production | Okay, it's not really software to download.  This is a guide that ensures your environment is configured correctly. |

### Progress ...so far
As it turns out, I've discovered that creating a plugin for the JetBrains IDE is incredibly difficult (...for _me_, anyway).  The information available in the API is _scant at best_ <sup id="am1">[1](#am)</sup>

 > **Big Props**
 >
 > One of the best references I used was the code for [MongoDB Integration in IntelliJ](https://github.com/dboissier/mongo4idea) (aka - [`mongo4idea`](https://github.com/dboissier/mongo4idea))
 > It was helpful to see how something was properly set up, like which keys had to align for settings to be persisted. 

This repository is a good example of what not to do.  I have not added good documentation to my classes/methods.  Mostly, this is because I didn't know how the API worked and what made the most sense.  For example, how best to persist certain preferences and build configurations.

-----------
<b id="am">1.</b>  This is a quote from _American Movie_, but I couldn't find a clip with the exact quote.  ...sooo, _go watch the movie!_  [↩](#am1)