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
package io.github.astrapi69.design.pattern.observer;

import io.github.astrapi69.design.pattern.observer.api.Observer;
import io.github.astrapi69.design.pattern.observer.api.Subject;
import io.github.astrapi69.design.pattern.observer.exception.ExceptionEvent;

/**
 * The class {@link ShowExceptionView} is an implementation of the {@link Observer} interface that
 * listens for changes in {@link ExceptionEvent} instances and reacts to those changes by displaying
 * the exception message.
 */
public class ShowExceptionView extends AbstractObserver<ExceptionEvent>
{

	/**
	 * Instantiates a new {@code ShowExceptionView} to observe the specified subject.
	 *
	 * @param subject
	 *            the subject to observe
	 */
	public ShowExceptionView(final Subject<ExceptionEvent, Observer<ExceptionEvent>> subject)
	{
		super(subject);
	}

	/**
	 * Executes the action when the observed {@link ExceptionEvent} changes This method prints the
	 * message of the exception to the console.
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void execute()
	{
		System.out.println("From ShowExceptionView:::" + getObservable().getValue() + ":::");
	}
}
