## Statics

Open your command prompt and `cd` into this README's directory (`foundation/23-statics`). 
Convert the source code in this project to use a static copy of **PowerSupply**. 
You will need to modify `Appliance.java`.

After you've finished, compile your code by running the following command:

```bash
$ javac -d bin src/com/bloc/statics/*.java src/com/bloc/statics/appliances/*.java
```

After it compiles successfully, `cd` into the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.statics.Main
```

If you see a nice congrats message, everything's been properly static-o-fied!

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 23 completed"
$ git push
```