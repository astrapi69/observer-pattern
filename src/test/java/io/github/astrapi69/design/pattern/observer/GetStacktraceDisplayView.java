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
 * The Class GetStacktraceDisplayView.
 */
public class GetStacktraceDisplayView extends AbstractObserver<ExceptionEvent>
{

	/**
	 * Instantiates a new gets the stacktrace display view.
	 *
	 * @param subject
	 *            the subject
	 */
	public GetStacktraceDisplayView(final Subject<ExceptionEvent, Observer<ExceptionEvent>> subject)
	{
		super(subject);
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see io.github.astrapi69.design.pattern.observer.api.ActionCommand#execute()
	 */
	@Override
	public void execute()
	{

		System.out.print("From GetStacktraceView:");
		getObservable().getValue().printStackTrace();

	}

}
