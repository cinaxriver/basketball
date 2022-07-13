package com.mycraftia.basketball.misc;

import org.jetbrains.annotations.NotNull;

public abstract class UseCase<I,O> {


    public abstract O execute(@NotNull final I input) throws Exception;

}
