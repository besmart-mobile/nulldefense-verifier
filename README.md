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

## Usage
To verify class ```MyClass``` implements correct null defense you should write test like this if using JUnit.
```
@Test
public void MyClass_implements_null_defense() {
    NullDefenseVerifier.forClass(MyClass.class).verify();
}
```

By 'correct null defense' throwing ```NullPointerException``` for any null argument is implied.
