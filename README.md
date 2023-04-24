# Guess the number

# Build & run

```bash
export PATH_TO_FX=lib/javafx-sdk-20.0.1/lib
```

Build:

```bash
javac -d build --module-path $PATH_TO_FX --add-modules javafx.controls src/net/abracadabralab/*.java
```

Run:

```bash
java -cp build --module-path $PATH_TO_FX --add-modules javafx.controls net.abracadabralab.App
```
