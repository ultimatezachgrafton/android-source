﻿## Inheritance

Open your command prompt and `cd` into this README's directory (`foundation/20-inheritance`).
Edit the following 3 files:

* `Chihuahua.java`
Extend the **Dog** class. Chihuahuas have a high metabolism, they only grow to a new size after being fed _5 times._

* `GreatDane.java`
Extend the **Dog** class. Great Danes can get rather large… 
Let's add another size category for them,`"huge"`. If a Great Dane is "large," after *3 additional meals* 
it will become "huge".

* `GoldenRetriever.java`
Extend the **Dog** class. Golden Retrievers are incredibly athletic, 
they shrink by one size after _only 3 plays._

Make sure you name the classes _identically_ to their respective file names, otherwise the tests will fail.
After you've finished, compile your Java code by running the following command:

```bash
$ javac -d bin/ src/com/bloc/inherit/*
```

Correct compilation errors as they are a result of modifications made by you.

After it returns successfully, `cd` into the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.inherit.Main
```

If you see a nice congrats message, you've written some pretty solid subclasses.

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 20 completed"
$ git push
```