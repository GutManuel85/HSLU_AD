/*
 * Copyright 2020 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package AD.SW12.n4.n4.quicksort;

import AD.SW11.Sort;
import AD.SW12.n4.n4.OwnImplementations.Quicksort;

import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 1;
    private final int[] array;
    private final int left;
    private final int right;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.left = min;
        this.right = max;
    }

    @Override
    protected void compute() {
        if (left - right <= THRESHOLD) {
            Sort.selectionSort(array);
        }
        if(left<right){
            int indexTrennelement = QuicksortRecursive.partition(array, left, right);
            QuicksortTask quicksortTask1 = new QuicksortTask(array, left, indexTrennelement - 1);
            QuicksortTask quicksortTask2 = new QuicksortTask(array, indexTrennelement + 1, right);
            invokeAll(quicksortTask1, quicksortTask2);
        }
    }
}
