package com.epam.mjc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        Pattern pattern = Pattern.compile("(?:(.+) )?(.+) (.+)\\((.*)\\)");
        Matcher matcher = pattern.matcher(signatureString);
        if (matcher.find()) {
            var accessModifier = matcher.group(1);
            var returnType = matcher.group(2);
            var methodName = matcher.group(3);
            var methodSignature = new MethodSignature(methodName);
            methodSignature.setAccessModifier(accessModifier);
            methodSignature.setReturnType(returnType);
            var arguments = matcher.group(4);
            if (!arguments.isEmpty()){
            var splitedArguments = arguments.split(", *");

            for (var sArguments:splitedArguments
                 ) {
                var splitedIntoTypeandName = sArguments.split(" ");
                var arg = new MethodSignature.Argument(splitedIntoTypeandName[0],splitedIntoTypeandName[1]);
                methodSignature.getArguments().add(arg);
            }}
            return methodSignature;
        }

        return null;
    }
}
