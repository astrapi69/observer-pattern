/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.design.pattern.observer.event;

import io.github.astrapi69.design.pattern.observer.api.Observer;
import io.github.astrapi69.design.pattern.observer.api.Subject;

/**
 * The class {@link DemonstrateEventObserver} demonstrates the use of the observer design pattern
 * with events It shows how to create a {@link Subject} and an {@link Observer} that react to
 * changes in the subject's state.
 */
public class DemonstrateEventObserver
{

	/**
	 * The main method to start the demonstration.
	 *
	 * @param args
	 *            the command line arguments
	 * @throws InterruptedException
	 *             if the thread sleep is interrupted
	 */
	public static void main(final String[] args) throws InterruptedException
	{
		System.out.println("Create a Subject...");
		final Subject<State, Observer<State>> stateSubject = new StateSubject();
		new EventObserver(stateSubject);
		stateSubject.setObservable(State.stop);
		Thread.sleep(2000);
		stateSubject.setObservable(State.spinning);
	}
}
