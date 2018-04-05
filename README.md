[![Build Status](https://travis-ci.org/besmart-mobile/nulldefense-verifier.svg?branch=master)](https://travis-ci.org/besmart-mobile/nulldefense-verifier)
# NullDefenseVerifier
With this library you can automate unit testing of arguments null checks.
It provides convinient one line way to verify correct null checks for arguments in all constructors, static and instance methods of the class under test.
The API is pretty much the same as in [EqualsVerifier](http://jqno.nl/equalsverifier/).

## Getting NullDefenseVerifier
Gradle:
Step 1. Add the JitPack repository to your build file
```
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
Step 2. Add the dependency
```
testCompile 'com.github.besmart-mobile:nulldefense-verifier:0.1.0'
```

## Basic Usage
To verify class ```MyClass``` implements correct null defense you should write test like this if using JUnit.
```
@Test
public void MyClass_implements_null_defense() {
    NullDefenseVerifier.forClass(MyClass.class).verify();
}
```

By 'correct null defense' throwing ```NullPointerException``` for any null argument is implied.

## Advanced Usage
It's possible to ignore checks for private methods/constructors
```
NullDefenseVerifier.forClass(MyClass.class)
        .ignorePrivate()
        .verify();
```
<br/>
<br/>
<br/>
    

It's possible to put ```@Nullable``` annotation on the parameter to skip null defense check for this parameter.
You can use any ```@Nullable``` annotation you want as it checked by simple name, not the whole type. Just remember that it MUST has ```RUNTIME``` ```RetentionPolicy```.
So for example you can use
- ```javax.annotation```
- ```javax.validation.constraints```
- ```org.checkerframework.checker.nullness.qual```
- a custom one

but not 
- ```android.support.annotation```
- ```edu.umd.cs.findbugs.annotations```
- ```org.eclipse.jdt.annotation```
- ```org.jetbrains.annotations```
