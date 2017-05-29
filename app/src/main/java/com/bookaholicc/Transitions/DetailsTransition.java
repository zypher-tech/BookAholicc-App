package com.bookaholicc.Transitions;

import android.support.transition.ChangeBounds;
import android.support.transition.TransitionSet;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Transition;

/**
 * Created by nandhu on 20/5/17.
 * The Details Transition
 */



public class DetailsTransition extends android.transition.TransitionSet {



    public DetailsTransition() {
        setOrdering(ORDERING_TOGETHER);
        addTransition(new android.transition.ChangeBounds()).
                addTransition(new ChangeImageTransform()).
                addTransition(new ChangeTransform());
    }
}