# BoulderLang

Simle Compiler, which compiles to x86 64-bit nasm style assembly. <br>
**This language is a work in progress. Everything can change at any time, so use it at your own risk.**

## Usage
Compilation generates assembly code, compiles it with [nasm](https://nasm.us/) and links it with the [GNU linker](https://www.gnu.org/software/binutils/), <br>so make sure you have it in you `$PATH`.

```
$ cat main.boulder
exit(0);
$ java -cp build Main main.boulder
$ ./bin/output.exe
```

## An Example

```
set number = 15;

(number > 20) exit(0);
\ (number > 10) {
  set code = 1;
  exit(code);
} \ exit(2);
```
This programm exits with `1`

## Language Reference
This is what the language supports so far.

### Integer Literat
A sequence of decimal digits.
```
327
```

### Boolean Literal
Either `true` or `false`, which are interpreted internally as `1` and `0`.
```
true
```

### Identifier
A sequence of at least one letter or decimal digit.
```
name
```

### Parentheses
An *Expression* surrounded by parentheses.
```
(age)
```

### Negated Term
A *Term* prefixed with a dash (`-`).
```
-654
```

### *Term (group class)*
Either *Integer Literal*, *Boolean*, *Identifier*, *Parentheses* or *Negated Term*.

### Binary Expression
Two *Expressions* connected with a *Binary Expression Type*.
```
num + 23
```

### *Expression (group class)*
Either *Term* or *Binary Expression*.

### Branch
A branch executing a *Statement* when its condition *Expression* is `true`. Optionally executes a *Statement*-Else when the condition is `false` and the *Statement* is suffixed with `\`.
```
(number == 42) result = true;
\ result = false;
```

### Assignment Statement
A *Statement* setting an already initialised *Identifier* equal to an *Expression*.
```
value = 76;
```

### Set Statement
A *Statement* setting a not already initialised *Identifier* equal to an *Expression*, prefixed with `set`.
```
set value = 76;
```

### Stop Statement
A *Statement* terminating the program with an exit code given by an *Expression*.
```
exit(32);
```

### Scope
*Statements* surrounded with curly braces (`{}`), having local variables, which cannot be accessed globally.
```
{
  set code = 1;
  exit(code);
}
```

### *Statement (group class)*
Either *Set Statement*, *Assignment Statement*, *Stop Statement*, *Branch* or *Scope*.
