package groovyHotReloading

class CalcImpl implements Calc {
    @Override
    int sum(int a, int b) {
        println('hello')
        a + b
    }
}